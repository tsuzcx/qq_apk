package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.biz.qqstory.takevideo.slideshow.QzoneSlideShowPhotoListManager;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;

public class QzoneSlideShowPreparingFragment
  extends PublicBaseFragment
  implements PublicFragmentActivityCallBackInterface
{
  private static final String a = QzoneSlideShowPhotoListManager.class.getName();
  private TextView b;
  private TextView c;
  private ProgressBar d;
  private ImageView e;
  private int f;
  private QQCustomDialog g;
  private Handler h = new QzoneSlideShowPreparingFragment.1(this, Looper.getMainLooper());
  private Runnable i = new QzoneSlideShowPreparingFragment.2(this);
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      if (paramIntent != null)
      {
        Object localObject2 = paramIntent.getStringExtra("key_content");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        int j = paramIntent.getIntExtra("key_priv", 1);
        Object localObject3 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new ArrayList();
        }
        int k = paramIntent.getIntExtra("key_font_id", -1);
        int m = paramIntent.getIntExtra("key_font_format_type", 0);
        localObject3 = paramIntent.getStringExtra("key_font_url");
        int n = paramIntent.getIntExtra("key_super_font_id", -1);
        String str = paramIntent.getStringExtra("key_super_font_info");
        boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
        boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
        boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
        if (paramIntent.n <= 5) {
          paramInt = paramIntent.n;
        } else {
          paramInt = 0;
        }
        int i1 = (int)paramIntent.j;
        FlowComponentInterface localFlowComponentInterface = (FlowComponentInterface)((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback();
        localFlowComponentInterface.setRefer(getClass().getName());
        a(paramIntent.u, paramInt, paramIntent.t, paramIntent.c, paramIntent.b, i1, localFlowComponentInterface, (String)localObject1, j, (ArrayList)localObject2, false, k, m, (String)localObject3, n, str, bool1, bool2, bool3);
        if (this.f == 18) {
          LpReportInfo_pf00064.allReport(585, 15, 9);
        }
        a();
        return;
      }
      return;
    }
    a();
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      ((IPtvFilterUtil)QRoute.api(IPtvFilterUtil.class)).createFakeVidConfigFile(paramString1, paramString4);
    }
    VideoSendPublicParamBase localVideoSendPublicParamBase = new VideoSendPublicParamBase();
    localVideoSendPublicParamBase.mContext = getBaseActivity();
    localVideoSendPublicParamBase.mVideoCacheDir = paramString1;
    localVideoSendPublicParamBase.mEncodeMode = paramInt1;
    localVideoSendPublicParamBase.mVideoFilePath = paramString2;
    localVideoSendPublicParamBase.mThumbFilePath = paramString3;
    localVideoSendPublicParamBase.mThumbWidth = 0;
    localVideoSendPublicParamBase.mThumbHeight = 0;
    localVideoSendPublicParamBase.fakeVid = paramString4;
    localVideoSendPublicParamBase.recordTime = paramInt2;
    localVideoSendPublicParamBase.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParamBase.mContent = paramString5;
    localVideoSendPublicParamBase.mPriv = paramInt3;
    localVideoSendPublicParamBase.mPrivUinList = paramArrayList;
    localVideoSendPublicParamBase.mEnableEditVideo = true;
    localVideoSendPublicParamBase.topicSyncQzone = paramBoolean1;
    localVideoSendPublicParamBase.fontId = paramInt4;
    localVideoSendPublicParamBase.fontFormatType = paramInt5;
    localVideoSendPublicParamBase.fontUrl = paramString6;
    localVideoSendPublicParamBase.superFontId = paramInt6;
    localVideoSendPublicParamBase.superFontInfo = paramString7;
    localVideoSendPublicParamBase.generateGif = paramBoolean2;
    localVideoSendPublicParamBase.timerDelete = paramBoolean3;
    localVideoSendPublicParamBase.isUploadOrigin = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VNeedOriginal", true);
    localVideoSendPublicParamBase.entrySource = QzoneSlideShowPhotoListManager.a().d();
    localVideoSendPublicParamBase.mUin = "";
    localVideoSendPublicParamBase.mUinType = 0;
    localVideoSendPublicParamBase.mTroopUin = "";
    ((IMediaCodecSendTask)QRoute.api(IMediaCodecSendTask.class)).execute(localVideoSendPublicParamBase);
  }
  
  private void c()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      localObject = (BitmapDrawable)((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        localObject = ((BitmapDrawable)localObject).getBitmap();
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
          ((Bitmap)localObject).recycle();
        }
      }
    }
  }
  
  private void d()
  {
    if (this.g == null)
    {
      String str = HardCodeUtil.a(2131909904);
      this.g = DialogUtil.a(getBaseActivity(), 230, str, null, HardCodeUtil.a(2131909905), HardCodeUtil.a(2131898212), new QzoneSlideShowPreparingFragment.5(this), new QzoneSlideShowPreparingFragment.6(this));
    }
    this.g.show();
  }
  
  public void a()
  {
    this.h.removeCallbacks(this.i);
    SlideShowPhotoListManager.a().j();
    getBaseActivity().finish();
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    a(paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.d(a, 2, "QzoneSlideShowPreparingFragment onCreate");
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d(a, 2, "QzoneSlideShowPreparingFragment onCreateView");
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(2131624739, paramViewGroup, false);
    this.b = ((TextView)paramLayoutInflater.findViewById(2131448490));
    this.c = ((TextView)paramLayoutInflater.findViewById(2131448311));
    this.d = ((ProgressBar)paramLayoutInflater.findViewById(2131439912));
    this.e = ((ImageView)paramLayoutInflater.findViewById(2131436505));
    this.d.setProgress(0);
    this.d.setMax(100);
    this.b.setText("0%");
    this.c.setOnClickListener(new QzoneSlideShowPreparingFragment.3(this));
    this.h.postDelayed(this.i, 200L);
    paramBundle = getBaseActivity().getIntent();
    if (paramBundle != null)
    {
      SlideShowPhotoListManager.a().j();
      paramViewGroup = paramBundle.getParcelableArrayListExtra("qzone_slide_show_matters");
      int k = paramBundle.getIntExtra("qqstory_slide_show_scene", 21);
      this.f = paramBundle.getIntExtra("entrance_qzone_p2v", -1);
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0) && (k == 22))
      {
        Object localObject = (LocalMediaInfo)paramViewGroup.get(0);
        if (((LocalMediaInfo)localObject).mMimeType.contains("image"))
        {
          new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
          paramBundle = BitmapFactory.decodeFile(((LocalMediaInfo)localObject).path);
          this.e.setImageBitmap(paramBundle);
        }
        else if (((LocalMediaInfo)localObject).mMimeType.contains("video"))
        {
          paramBundle = new MediaMetadataRetriever();
          paramBundle.setDataSource(((LocalMediaInfo)localObject).path);
          localObject = paramBundle.getFrameAtTime(0L, 3);
          paramBundle.release();
          this.e.setImageBitmap((Bitmap)localObject);
        }
        paramBundle = new ArrayList();
        while (j < paramViewGroup.size())
        {
          paramBundle.add(new SlideItemInfo((LocalMediaInfo)paramViewGroup.get(j)));
          j += 1;
        }
        SlideShowPhotoListManager.a().b(paramBundle);
        SlideShowPhotoListManager.a().a(paramBundle);
        SlideShowPhotoListManager.a().c(k);
        SlideShowPhotoListManager.a().b(this.f);
        SlideShowPhotoListManager.a().a(getBaseActivity(), new QzoneSlideShowPreparingFragment.4(this), 2);
      }
      else
      {
        QLog.e(a, 2, "slideShowLocalMediaInfos is null or SlideShowScene is not QzoneSlideShowPhotoListManager.SCENE_QZONE");
        a();
      }
    }
    LpReportInfo_pf00064.allReport(680, 1, 1);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.d(a, 2, "QzoneSlideShowPreparingFragment onDestroy");
    c();
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment
 * JD-Core Version:    0.7.0.1
 */