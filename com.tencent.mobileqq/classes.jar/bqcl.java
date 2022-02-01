import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager.3;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class bqcl
  extends bqgk
  implements bbqf, bmkp
{
  private Intent b;
  
  private void D()
  {
    String str1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("mCurrentTemplatePath");
    int i;
    int j;
    label33:
    String str2;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c() == 104)
    {
      i = 1;
      if (TextUtils.isEmpty(str1)) {
        break label128;
      }
      j = 1;
      if (j != 0)
      {
        j = b();
        str2 = a(str1);
        if (!a()) {
          break label133;
        }
      }
    }
    label128:
    label133:
    for (str1 = "2";; str1 = "1")
    {
      b("pub_changeface", j, 0, new String[] { "1", str2, str1 });
      if (i != 0) {
        yup.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
      }
      if (b()) {
        yup.a("video_edit", "pub_local", 0, 0, new String[0]);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label33;
    }
  }
  
  private void a(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_Bqhs.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    blir localblir = blir.c(localActivity);
    localblir.b(2131692962);
    localblir.b(2131692968);
    localblir.b(2131692960);
    localblir.c(2131690580);
    localblir.a(new bqco(this, localblir, paramIntent, str, localActivity));
    localblir.show();
  }
  
  private void a(Observer<bqua> paramObserver)
  {
    bqua localbqua = new bqua(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbqua.b = bqut.a(2);
    localbqua.jdField_a_of_type_Bqug = new bqug(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    localbqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    localbqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    localbqua.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bqgi)((Iterator)localObject).next()).a(0, localbqua);
    }
    localObject = localbqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      if (!TextUtils.isEmpty(localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
        break label336;
      }
    }
    label336:
    StringBuilder localStringBuilder;
    PublishVideoEntry localPublishVideoEntry;
    for (localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject);; localPublishVideoEntry.videoDoodleDescription += (String)localObject)
    {
      localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
      localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.c()));
      yuq.b("0X80076EA");
      yuk.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
      this.jdField_a_of_type_Bqhs.a(anzj.a(2131702571), false, 500L);
      Stream.of(localbqua).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new bqud((bqbr)a(bqbr.class), null)).map(new bqur(bqcj.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new bqup()).map(new bquv(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
      return;
      localStringBuilder = new StringBuilder();
      localPublishVideoEntry = localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    }
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_a_of_type_Bqhs != null)
    {
      Activity localActivity = this.jdField_a_of_type_Bqhs.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private static void b(bqcl parambqcl)
  {
    for (;;)
    {
      int i;
      try
      {
        parambqcl = ((bqbr)parambqcl.a(bqbr.class)).a();
        int j;
        if (!parambqcl.a().a())
        {
          parambqcl = parambqcl.a.a();
          j = parambqcl.jdField_a_of_type_Int;
          k = parambqcl.b;
          i = -1;
        }
        switch (j)
        {
        case 0: 
          bdll.b(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception parambqcl)
      {
        int k;
        yuk.d("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
        return;
      }
      switch (k)
      {
      default: 
        break;
      case -1: 
        i = 2;
        break;
      case -2148308: 
        i = 3;
        break;
      case -1009097: 
        i = 4;
        break;
      case -8136876: 
        i = 5;
        break;
      case -13338378: 
        i = 6;
        break;
      case -16777216: 
        i = 12;
        continue;
        i = 1;
        continue;
        switch (k)
        {
        default: 
          break;
        case 1: 
          i = 7;
          break;
        case 2: 
          i = 8;
          break;
        case 3: 
          i = 9;
          break;
        case 4: 
          i = 10;
          break;
        case 5: 
          i = 11;
          continue;
          i = -1;
        }
        break;
      }
    }
  }
  
  private void c(int paramInt)
  {
    String str = agju.a(antf.bn);
    Activity localActivity = this.jdField_a_of_type_Bqhs.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel()) {
      QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.jdField_a_of_type_Bqhs.getActivity() + " new path " + str);
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Bqhs.a()).edit().putString("edit_pic_new_path", str).commit();
    Intent localIntent = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), localIntent);
    localIntent.putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult(localIntent, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      QQToast.a(localActivity, anzj.a(2131702577), 0).a();
      localActivity.finish();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
      }
    }
  }
  
  protected SimpleObserver<bqua> a()
  {
    return new bqcm(this);
  }
  
  public void a()
  {
    D();
    a(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    if (paramInt1 == 18001) {
      if (paramInt2 == -1) {
        AIOLongShotHelper.a(this.jdField_a_of_type_Bqhs.getActivity(), paramIntent);
      }
    }
    while ((paramInt1 != 18002) || (paramInt2 != -1))
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)));
      this.jdField_a_of_type_Bqhs.a(-1, this.b, 2130772029, 0, false);
      this.b = null;
      return;
    }
    this.jdField_a_of_type_Bqhs.a(-1, this.b, 2130772029, 0, false);
    this.b = null;
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    default: 
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Bqhs.a(-1, null, 2130772029, 0, true);
      return;
    case 101: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1000);
      yup.a("plus_shoot", "exp_send", 0, 0, new String[] { "", "", "", "" });
      return;
    case 7: 
      if (QLog.isColorLevel())
      {
        Object localObject = paramIntent.getComponent();
        String str = ((ComponentName)localObject).getClassName();
        localObject = ((ComponentName)localObject).getPackageName();
        QLog.i("EditPicActivity.EditPicPartManager", 2, String.format(Locale.getDefault(), "gotoActivityForBusiness [%s, %s]", new Object[] { str, localObject }));
      }
      paramIntent.addFlags(603979776);
      paramIntent.removeExtra("PhotoConst.PHOTO_PATHS");
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 6: 
      paramIntent.setFlags(536870912);
      paramIntent.removeExtra(EditVideoParams.class.getName());
      paramActivity.startActivityForResult(paramIntent, 1001);
      return;
    case 103: 
      paramIntent.addFlags(603979776);
      paramIntent.putExtra("sub_business_id", 103);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    case 8: 
      paramIntent.setClass(paramActivity, ReadInJoyDeliverUGCActivity.class);
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
    if ((this.jdField_a_of_type_Bqhs.getActivity() != null) && (this.jdField_a_of_type_Bqhs.getActivity().getIntent() != null) && (this.jdField_a_of_type_Bqhs.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false))) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramActivity.startActivity(paramIntent);
      this.jdField_a_of_type_Bqhs.a(-1, null, 2130772029, 0, true);
      return;
    }
    this.jdField_a_of_type_Bqhs.a(-1, paramIntent, 2130772029, 0, true);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new bqeb(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bqeb = ((bqeb)localObject);
    localArrayList.add(localObject);
    localObject = new bqcu(this);
    this.jdField_a_of_type_Bqcu = ((bqcu)localObject);
    localArrayList.add(localObject);
    localObject = new bqeq(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bqeq = ((bqeq)localObject);
    localArrayList.add(localObject);
    localObject = new EditPicRawImage(this, paramEditVideoParams.jdField_a_of_type_Long);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    localObject = new bqck(this);
    this.jdField_a_of_type_Bqck = ((bqck)localObject);
    localArrayList.add(localObject);
    localObject = new bqgv(this);
    this.jdField_a_of_type_Bqgv = ((bqgv)localObject);
    localArrayList.add(localObject);
    localObject = new bqgx(this);
    this.jdField_a_of_type_Bqgx = ((bqgx)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 128))
    {
      localObject = new EditVideoArtFilter(this);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoArtFilter = ((EditVideoArtFilter)localObject);
      localArrayList.add(localObject);
    }
    if ((a(paramEditVideoParams.jdField_a_of_type_Long, 1)) && (a(paramEditVideoParams.jdField_a_of_type_Long, 274877906944L)) && (paramEditVideoParams.jdField_a_of_type_Int == 1) && (((DynamicTextConfigManager)bplq.a(7)).c()))
    {
      localObject = new bqen(this, paramEditVideoParams.e);
      this.jdField_a_of_type_Bqen = ((bqen)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 8192))
    {
      localObject = new bqcp(this);
      this.jdField_a_of_type_Bqcp = ((bqcp)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 67108864))
    {
      localObject = new bqhk(this);
      this.jdField_a_of_type_Bqhk = ((bqhk)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))
    {
      localObject = new bqgq(this);
      this.jdField_a_of_type_Bqgq = ((bqgq)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 8388608))
    {
      localObject = new bqhe(this);
      this.jdField_a_of_type_Bqhe = ((bqhe)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 268435456))
    {
      localObject = new bqhv(this);
      this.jdField_a_of_type_Bqhv = ((bqhv)localObject);
      localArrayList.add(localObject);
      localObject = new bqry(this);
      this.jdField_a_of_type_Bqry = ((bqry)localObject);
      localArrayList.add(localObject);
      localObject = new bqfw(this, this.jdField_a_of_type_Bqhv, this.jdField_a_of_type_Bqry);
      this.jdField_a_of_type_Bqfw = ((bqfw)localObject);
      localArrayList.add(localObject);
    }
    if ((paramEditVideoParams.jdField_a_of_type_Int == 1) && (a(paramEditVideoParams.jdField_a_of_type_Long, 131072))) {
      localArrayList.add(new bqdj(this));
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 33554432))
    {
      localObject = new bqge(this);
      this.jdField_a_of_type_Bqge = ((bqge)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 34359738368L))
    {
      localObject = new bqgc(this);
      this.jdField_a_of_type_Bqgc = ((bqgc)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 1073741824))
    {
      localObject = new bqbx(this);
      this.jdField_a_of_type_Bqbx = ((bqbx)localObject);
      localArrayList.add(localObject);
    }
    int i;
    if (a(paramEditVideoParams.jdField_a_of_type_Long, 16384))
    {
      if (paramEditVideoParams.jdField_a_of_type_AndroidOsBundle != null) {
        break label747;
      }
      i = -1;
      if (i != -1) {
        break label762;
      }
      yuk.e("EditPicActivity.EditPicPartManager", "pic curType have not set but it use BUSINESS_QQ ID, that is illegal!!");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList = localArrayList;
      return;
      label747:
      i = paramEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("uintype", -1);
      break;
      label762:
      this.jdField_a_of_type_Bqbn = new bqbn(this, i, false);
      localArrayList.add(this.jdField_a_of_type_Bqbn);
    }
  }
  
  public void a(Error paramError)
  {
    yuk.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Bqhs.b();
    QQToast.a(this.jdField_a_of_type_Bqhs.a(), anzj.a(2131702574) + paramError, 0).a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_Bqhs.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    int k;
    if ((i == 103) && (i == 103))
    {
      i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
      j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
      k = ((Intent)localObject).getIntExtra("camera_capture_method", -1);
      if (i != 0) {
        break label326;
      }
      localObject = "0";
      if (j == -1) {
        break label333;
      }
      bdll.b(null, "dc00898", "", "", "0X8007376", "0X8007376", 0, 0, (String)localObject, "" + j, "", "");
      yuq.b("0X80075E8");
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("cameraFrontBack", "" + i);
      ((HashMap)localObject).put("templateId", "" + j);
      ((HashMap)localObject).put("photoCaptureMethod", "" + k);
      bdmc.a(BaseApplication.getContext()).a(null, "photo_send_from_shortvideo", true, 0L, 0L, (HashMap)localObject, "");
      if (QLog.isColorLevel()) {
        QLog.e("EditPicActivity.EditPicPartManager", 2, "[ShortVideoMergeReport] tag=photo_send_from_shortvideo templateId=" + j + " camera=" + i);
      }
      ((bpmw)bplq.a(5)).a(this.jdField_a_of_type_Bqhs.getActivity());
      return;
      label326:
      localObject = "1";
      break;
      label333:
      bdll.b(null, "dc00898", "", "", "0X8007375", "0X8007375", 0, 0, (String)localObject, "" + j, "", "");
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      b(1000L);
    }
  }
  
  protected void c()
  {
    Object localObject = this.jdField_a_of_type_Bqhs.getActivity().getIntent();
    int i = ((Intent)localObject).getIntExtra("camera_type", -1);
    int j;
    if (i != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + i + " clear photo " + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      }
      new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a()).delete();
      bhmq.a(this.jdField_a_of_type_Bqhs.a(), this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
      Intent localIntent = new Intent();
      localIntent.putExtra("p_e_r_c", true);
      localIntent.putExtra("camera_type", i);
      if (i == 103)
      {
        i = ((Intent)localObject).getIntExtra("camera_front_back", 0);
        j = ((Intent)localObject).getIntExtra("camera_filter_id", -1);
        if (i == 0)
        {
          localObject = "0";
          if (j == -1) {
            break label324;
          }
          bdll.b(null, "dc00898", "", "", "0X80072C6", "0X80072C6", 0, 0, (String)localObject, "" + j, "", "");
          label241:
          this.jdField_a_of_type_Bqhs.a(0, localIntent, 2130772029, 0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a() == 1)
      {
        i = g();
        yup.b("time_edit", 1, (int)(System.currentTimeMillis() - d()), new String[] { yup.b(i), "1", "", "" });
      }
      return;
      localObject = "1";
      break;
      label324:
      bdll.b(null, "dc00898", "", "", "0X80072C7", "0X80072C7", 0, 0, (String)localObject, "" + j, "", "");
      break label241;
      c(i);
      continue;
      this.jdField_a_of_type_Bqhs.a(0, null, 2130772029, 0);
    }
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Bqhs.a(anzj.a(2131702572), false, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqcl
 * JD-Core Version:    0.7.0.1
 */