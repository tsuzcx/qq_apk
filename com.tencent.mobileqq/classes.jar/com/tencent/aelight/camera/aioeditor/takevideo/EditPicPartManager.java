package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MakeStoryPicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.OnSavePhoto;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qqfav.QfavBuilder.OnAddFav;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditPicPartManager
  extends EditVideoPartManager
  implements AIOGalleryUtils.OnSavePhoto, QfavBuilder.OnAddFav
{
  private Intent a;
  
  private void a(long paramLong)
  {
    if (this.H != null)
    {
      Activity localActivity = this.H.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    Activity localActivity = this.H.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(localActivity);
    localActionSheet.addButton(2131890804);
    localActionSheet.addButton(2131890810);
    localActionSheet.addButton(2131890802);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new EditPicPartManager.2(this, localActionSheet, paramIntent, str, localActivity));
    localActionSheet.show();
  }
  
  private void a(Observer<GenerateContext> paramObserver)
  {
    Object localObject1 = new GenerateContext(this.I);
    ((GenerateContext)localObject1).p = PublishFileManager.a(2);
    ((GenerateContext)localObject1).l = new GeneratePicArgs(this.I.e.a());
    ((GenerateContext)localObject1).o = new LpReportInfo_pf00064();
    ((GenerateContext)localObject1).o.actionType = 615;
    ((GenerateContext)localObject1).o.subactionType = 8;
    Object localObject2 = this.J.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a(0, (GenerateContext)localObject1);
    }
    localObject2 = ((GenerateContext)localObject1).a.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (TextUtils.isEmpty(((GenerateContext)localObject1).d.videoDoodleDescription))
      {
        ((GenerateContext)localObject1).d.videoDoodleDescription = ((String)localObject2);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((GenerateContext)localObject1).d;
        localStringBuilder.append(localPublishVideoEntry.videoDoodleDescription);
        localStringBuilder.append((String)localObject2);
        localPublishVideoEntry.videoDoodleDescription = localStringBuilder.toString();
      }
    }
    ((GenerateContext)localObject1).d.putExtra("composite_key_capturemode", Integer.valueOf(T()));
    ((GenerateContext)localObject1).d.putExtra("composite_key_entrance", Integer.valueOf(this.I.j()));
    VideoEditReport.b("0X80076EA");
    SLog.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
    this.H.showLoadingDialog(HardCodeUtil.a(2131901779), false, 500L);
    localObject1 = Stream.of(localObject1).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(EditPicConstants.a);
    ((StringBuilder)localObject2).append("qq_pic_merged_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    ((Stream)localObject1).map(new MergePicSegment(((StringBuilder)localObject2).toString())).map(new MakeStoryPicSegment()).map(new PublishVideoSegment(this.I)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private static void c(EditPicPartManager paramEditPicPartManager)
  {
    try
    {
      paramEditPicPartManager = ((EditDoodleExport)paramEditPicPartManager.a(EditDoodleExport.class)).b();
      if (paramEditPicPartManager.getLineLayer().c()) {
        break label108;
      }
      paramEditPicPartManager = paramEditPicPartManager.s.getCurrentStroke();
      int j = paramEditPicPartManager.c;
      k = paramEditPicPartManager.d;
      i = -1;
      if (j == 0) {
        break label178;
      }
      if (j == 1) {
        break label173;
      }
      if (j == 2) {
        break label113;
      }
    }
    catch (Exception paramEditPicPartManager)
    {
      label173:
      label178:
      for (;;)
      {
        int k;
        int i;
        label108:
        continue;
        label113:
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                if (k != 5) {
                  i = -1;
                } else {
                  i = 11;
                }
              }
              else {
                i = 10;
              }
            }
            else {
              i = 9;
            }
          }
          else {
            i = 8;
          }
        }
        else
        {
          i = 7;
          continue;
          i = 1;
          continue;
          if (k != -16777216)
          {
            if (k != -13338378)
            {
              if (k != -8136876)
              {
                if (k != -2148308)
                {
                  if (k != -1009097)
                  {
                    if (k == -1) {
                      i = 2;
                    }
                  }
                  else {
                    i = 4;
                  }
                }
                else {
                  i = 3;
                }
              }
              else {
                i = 5;
              }
            }
            else {
              i = 6;
            }
          }
          else {
            i = 12;
          }
        }
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
    return;
    SLog.d("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
  }
  
  private void d()
  {
    int i;
    if (this.I.j() == 104) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      StoryReportor.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
    }
    if (k()) {
      StoryReportor.a("video_edit", "pub_local", 0, 0, new String[0]);
    }
  }
  
  private void e()
  {
    String str = PlusPanelUtils.a(AppConstants.SDCARD_IMG_CAMERA);
    Activity localActivity = this.H.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reset2Camera begin ");
      ((StringBuilder)localObject).append(this.H.getActivity());
      ((StringBuilder)localObject).append(" new path ");
      ((StringBuilder)localObject).append(str);
      QLog.d("EditPicActivity.EditPicPartManager", 2, ((StringBuilder)localObject).toString());
    }
    PreferenceManager.getDefaultSharedPreferences(this.H.getContext()).edit().putString("edit_pic_new_path", str).commit();
    Object localObject = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), (Intent)localObject);
    ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult((Intent)localObject, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      QQToast.makeText(localActivity, HardCodeUtil.a(2131901785), 0).show();
    }
    catch (Exception localException2)
    {
      label184:
      break label184;
    }
    QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
    localActivity.finish();
  }
  
  public void a()
  {
    d();
    a(f());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.G = paramIntent;
    }
    if (paramInt1 == 18001)
    {
      if (paramInt2 == -1)
      {
        AIOLongShotHelper.a(this.H.getActivity(), paramIntent);
        return;
      }
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)))
      {
        this.H.finish(-1, this.a, 2130772081, 0, false);
        this.a = null;
      }
    }
    else if ((paramInt1 == 18002) && (paramInt2 == -1))
    {
      this.H.finish(-1, this.a, 2130772081, 0, false);
      this.a = null;
    }
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    if (paramInt != 6)
    {
      if (paramInt != 8)
      {
        if (paramInt != 103)
        {
          if ((paramInt != 106) && (paramInt != 109))
          {
            paramActivity.startActivity(paramIntent);
            this.H.finish(-1, null, 2130772081, 0, true);
            return;
          }
          paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
          Activity localActivity = this.H.getActivity();
          int i = 0;
          paramInt = i;
          if (localActivity != null)
          {
            paramInt = i;
            if (this.H.getActivity().getIntent() != null)
            {
              paramInt = i;
              if (this.H.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false)) {
                paramInt = 1;
              }
            }
          }
          if (paramInt == 0)
          {
            paramActivity.startActivity(paramIntent);
            this.H.finish(-1, null, 2130772081, 0, true);
            return;
          }
          this.H.finish(-1, paramIntent, 2130772081, 0, true);
          return;
        }
        paramIntent.addFlags(603979776);
        paramIntent.putExtra("qq_sub_business_id", 103);
        paramActivity.startActivity(paramIntent);
        paramActivity.setResult(-1);
        paramActivity.finish();
        return;
      }
      paramIntent.setClass(paramActivity, ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverUgcActivityClazz());
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.setFlags(536870912);
    paramIntent.removeExtra(EditVideoParams.class.getName());
    paramActivity.startActivityForResult(paramIntent, 1001);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    if (15 == this.I.a)
    {
      localObject = new EditARCakeButton(this);
      this.L = ((EditARCakeButton)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      localObject = new EditVideoButton(this, paramEditVideoParams.c);
      this.K = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
      localObject = new EditProviderPart(this);
      this.N = ((EditProviderPart)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoDoodle(this, paramEditVideoParams.c);
      this.O = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
      localObject = new EditPicCropPart(this);
      this.S = ((EditPicCropPart)localObject);
      localArrayList.add(localObject);
    }
    Object localObject = new EditPicRawImage(this, paramEditVideoParams.c);
    this.R = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.c, 512))
    {
      localObject = new EditPicSave(this);
      this.U = ((EditPicSave)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      localObject = new EditVideoLimitRegion(this);
      this.ab = ((EditVideoLimitRegion)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 2048))
    {
      localObject = new EditJumpToPtu(this);
      this.ac = ((EditJumpToPtu)localObject);
      localArrayList.add(localObject);
    }
    if (EditPicMeiHua.b(paramEditVideoParams.c)) {
      localArrayList.add(new EditPicMeiHua(this));
    }
    if (2 == this.I.a)
    {
      paramEditVideoParams = new DocEnhancePart(this);
      this.X = paramEditVideoParams;
      localArrayList.add(paramEditVideoParams);
    }
    this.J = localArrayList;
  }
  
  public void a(Error paramError)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PIC PUBLISH error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditPicActivity.EditPicPartManager", ((StringBuilder)localObject).toString());
    this.H.dismissLoadingDialog();
    localObject = this.H.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901782));
    localStringBuilder.append(paramError);
    QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(1000L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(1000L);
    }
  }
  
  protected SimpleObserver<GenerateContext> f()
  {
    return new EditPicPartManager.1(this);
  }
  
  public void g()
  {
    ((CaptureComboManager)QIMManager.a(5)).a(this.H.getActivity());
  }
  
  protected void h()
  {
    int i = this.H.getActivity().getIntent().getIntExtra("camera_type", -1);
    if (i != -1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("giveUpEditVideo, is from camera");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" clear photo ");
        ((StringBuilder)localObject).append(this.I.e.a());
        QLog.d("EditPicActivity.EditPicPartManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(this.I.e.a());
      if (AECommonUtil.a(this.H.getContext(), (File)localObject)) {
        ((File)localObject).delete();
      }
      ImageUtil.b(this.H.getContext(), this.I.e.a());
      localObject = new Intent();
      ((Intent)localObject).putExtra("p_e_r_c", true);
      ((Intent)localObject).putExtra("camera_type", i);
      if (i == 103)
      {
        this.H.finish(0, (Intent)localObject, 2130772081, 0);
        return;
      }
      e();
      return;
    }
    this.H.finish(0, null, 2130772081, 0);
  }
  
  public void i()
  {
    super.i();
    this.H.showLoadingDialog(HardCodeUtil.a(2131901780), false, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager
 * JD-Core Version:    0.7.0.1
 */