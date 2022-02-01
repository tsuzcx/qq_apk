package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.aeeditor.AEEditorProcessManager;
import com.tencent.aelight.camera.aeeditor.data.AEEditorVideoInfo;
import com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment;
import com.tencent.aelight.camera.aeeditor.module.export.AEEditorGenerateRunnable;
import com.tencent.aelight.camera.aeeditor.module.params.ParamFactory;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qcircle.tavcut.exporter.VideoExporter;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.timeline.CoverSelectView;
import com.tencent.qcircle.tavcut.timeline.CoverSelectView.UIConfigWrapper;
import com.tencent.qcircle.tavcut.view.TAVCutVideoView;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.ModelExtKt;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;

public class AECoverSelectFragment
  extends AbsAEPublishVideoProcessFragment
  implements View.OnClickListener
{
  public static final float DEFAULT_COVER_PROGRESS = 0.0F;
  private static final String TAG = "AECoverSelectFragment";
  CoverSelectView coverSelectView;
  TAVCutVideoSession coverVideoSession;
  private float defaultCoverProgress;
  FrameLayout flCoverSelectContainer;
  LinearLayout llBottomContainer;
  TextView tvCancel;
  TextView tvConfirm;
  
  private void addCoverSelectView()
  {
    Object localObject = new CoverSelectView.UIConfigWrapper(getBaseActivity(), 2063925492, 2063925395, 2063925394, 2063925442, 2063925443, 2063925444, 2063925445, 2063925484, 11);
    ((CoverSelectView.UIConfigWrapper)localObject).setPrevibarHeight(DisplayUtil.b(getBaseActivity(), 59.0F)).setPreviewBarWidth(DisplayUtil.b(getBaseActivity(), 34.0F)).setCoverDefaultProgress(this.defaultCoverProgress);
    this.coverSelectView = new CoverSelectView(getBaseActivity(), (CoverSelectView.UIConfigWrapper)localObject);
    int i = DisplayUtil.b(getBaseActivity(), 4.0F);
    int j = DisplayUtil.b(getBaseActivity(), 2.0F);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addCoverSelectView: pixValue2Dip = ");
    ((StringBuilder)localObject).append(j);
    Log.d("AECoverSelectFragment", ((StringBuilder)localObject).toString());
    int k = DisplayUtil.b(getBaseActivity(), 16.0F);
    int m = DisplayUtil.b(getBaseActivity(), 13.0F);
    localObject = new AERoundCornerImageView(getBaseActivity());
    ((AERoundCornerImageView)localObject).setCorner(j);
    ((AERoundCornerImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    float f = i;
    localShapeDrawable.setShape(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    ((AERoundCornerImageView)localObject).setBackgroundDrawable(localShapeDrawable);
    ((AERoundCornerImageView)localObject).setPadding(j, j, j, j);
    this.coverSelectView.setCoverPreviewBarBg(localShapeDrawable);
    this.coverSelectView.setPreviewBar((ImageView)localObject);
    this.coverSelectView.setPreviewBarElevation(15.0F);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    this.coverSelectView.setTimelineViewPadding(k, m, k, m);
    this.flCoverSelectContainer.addView(this.coverSelectView, (ViewGroup.LayoutParams)localObject);
  }
  
  private float getDefaultCoverProgress()
  {
    Bundle localBundle = getArguments();
    float f1;
    if (getBaseActivity().getIntent().getExtras() != null) {
      f1 = getBaseActivity().getIntent().getFloatExtra("key_video_cover_position", 0.0F);
    } else {
      f1 = 0.0F;
    }
    float f2 = f1;
    if (f1 == 0.0F)
    {
      f2 = f1;
      if (localBundle != null)
      {
        f2 = f1;
        if (localBundle.containsKey("key_video_cover_position")) {
          f2 = localBundle.getFloat("key_video_cover_position", 0.0F);
        }
      }
    }
    return f2;
  }
  
  private long getTotalDuration(@NonNull VideoResourceModel paramVideoResourceModel)
  {
    if ((this.missionId != null) && (this.missionId.startsWith("multi_video_"))) {
      return this.tavCutVideoSession.getDuration().getTimeUs() / 1000L;
    }
    return paramVideoResourceModel.getSelectTimeDuration();
  }
  
  /* Error */
  private void saveDataAndQuit()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: invokevirtual 256	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:showLoading	(Z)V
    //   5: aload_0
    //   6: getfield 76	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:coverSelectView	Lcom/tencent/qcircle/tavcut/timeline/CoverSelectView;
    //   9: invokevirtual 259	com/tencent/qcircle/tavcut/timeline/CoverSelectView:getCurrCoverProgress	()F
    //   12: fstore 4
    //   14: fload 4
    //   16: fstore_3
    //   17: fload 4
    //   19: ldc_w 260
    //   22: fcmpl
    //   23: ifne +19 -> 42
    //   26: fload 4
    //   28: f2d
    //   29: dstore_1
    //   30: dload_1
    //   31: invokestatic 266	java/lang/Double:isNaN	(D)Z
    //   34: pop
    //   35: dload_1
    //   36: ldc2_w 267
    //   39: dsub
    //   40: d2f
    //   41: fstore_3
    //   42: aload_0
    //   43: getfield 76	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:coverSelectView	Lcom/tencent/qcircle/tavcut/timeline/CoverSelectView;
    //   46: invokevirtual 272	com/tencent/qcircle/tavcut/timeline/CoverSelectView:getCurrCoverBitmap	()Landroid/graphics/Bitmap;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnonnull +17 -> 70
    //   56: ldc 13
    //   58: ldc_w 274
    //   61: invokestatic 279	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: iconst_0
    //   66: invokevirtual 256	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:showLoading	(Z)V
    //   69: return
    //   70: new 79	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   77: astore 6
    //   79: aload 6
    //   81: ldc_w 281
    //   84: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 6
    //   90: aload 5
    //   92: invokevirtual 287	android/graphics/Bitmap:getWidth	()I
    //   95: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: ldc_w 289
    //   104: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: aload 5
    //   112: invokevirtual 292	android/graphics/Bitmap:getHeight	()I
    //   115: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 13
    //   121: aload 6
    //   123: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 294	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: new 79	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   136: astore 6
    //   138: aload 6
    //   140: getstatic 299	com/tencent/aelight/camera/aeeditor/AEEditorPath$EDITOR$FILES:g	Ljava/lang/String;
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 6
    //   149: getstatic 304	java/io/File:separator	Ljava/lang/String;
    //   152: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 6
    //   158: aload_0
    //   159: getfield 219	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:missionId	Ljava/lang/String;
    //   162: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 6
    //   168: ldc_w 306
    //   171: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 6
    //   177: invokestatic 311	java/lang/System:currentTimeMillis	()J
    //   180: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 6
    //   186: ldc_w 316
    //   189: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 6
    //   195: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 6
    //   200: new 301	java/io/File
    //   203: dup
    //   204: aload 6
    //   206: invokespecial 319	java/io/File:<init>	(Ljava/lang/String;)V
    //   209: astore 7
    //   211: aload 7
    //   213: invokevirtual 323	java/io/File:getParentFile	()Ljava/io/File;
    //   216: invokevirtual 327	java/io/File:exists	()Z
    //   219: ifne +22 -> 241
    //   222: aload 7
    //   224: invokevirtual 323	java/io/File:getParentFile	()Ljava/io/File;
    //   227: invokevirtual 330	java/io/File:mkdirs	()Z
    //   230: ifne +11 -> 241
    //   233: ldc 13
    //   235: ldc_w 332
    //   238: invokestatic 279	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload 7
    //   243: invokevirtual 335	java/io/File:createNewFile	()Z
    //   246: ifne +11 -> 257
    //   249: ldc 13
    //   251: ldc_w 337
    //   254: invokestatic 279	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 5
    //   259: aload 6
    //   261: invokestatic 343	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   264: ifeq +94 -> 358
    //   267: new 79	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   274: astore 5
    //   276: aload 5
    //   278: ldc_w 345
    //   281: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 5
    //   287: aload 6
    //   289: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: ldc 13
    //   295: aload 5
    //   297: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 294	com/tencent/aelight/camera/log/AEQLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: new 195	android/content/Intent
    //   306: dup
    //   307: invokespecial 346	android/content/Intent:<init>	()V
    //   310: astore 5
    //   312: aload 5
    //   314: ldc 200
    //   316: fload_3
    //   317: invokevirtual 350	android/content/Intent:putExtra	(Ljava/lang/String;F)Landroid/content/Intent;
    //   320: pop
    //   321: aload 5
    //   323: ldc_w 352
    //   326: aload 6
    //   328: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   331: pop
    //   332: aload 5
    //   334: ldc_w 357
    //   337: aload_0
    //   338: invokevirtual 360	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getMediaPath	()Ljava/lang/String;
    //   341: invokevirtual 355	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   344: pop
    //   345: aload_0
    //   346: invokevirtual 37	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   349: iconst_m1
    //   350: aload 5
    //   352: invokevirtual 364	com/tencent/mobileqq/app/BaseActivity:setResult	(ILandroid/content/Intent;)V
    //   355: goto +81 -> 436
    //   358: ldc 13
    //   360: ldc_w 366
    //   363: invokestatic 279	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: invokevirtual 37	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   370: iconst_0
    //   371: invokevirtual 368	com/tencent/mobileqq/app/BaseActivity:setResult	(I)V
    //   374: goto +62 -> 436
    //   377: astore 5
    //   379: goto +70 -> 449
    //   382: astore 5
    //   384: aload 5
    //   386: invokevirtual 371	java/lang/Exception:printStackTrace	()V
    //   389: new 79	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   396: astore 6
    //   398: aload 6
    //   400: ldc_w 373
    //   403: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 6
    //   409: aload 5
    //   411: invokevirtual 374	java/lang/Exception:toString	()Ljava/lang/String;
    //   414: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: ldc 13
    //   420: aload 6
    //   422: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 279	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 37	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   432: iconst_0
    //   433: invokevirtual 368	com/tencent/mobileqq/app/BaseActivity:setResult	(I)V
    //   436: aload_0
    //   437: iconst_0
    //   438: invokevirtual 256	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:showLoading	(Z)V
    //   441: aload_0
    //   442: invokevirtual 37	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   445: invokevirtual 377	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   448: return
    //   449: aload_0
    //   450: iconst_0
    //   451: invokevirtual 256	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:showLoading	(Z)V
    //   454: aload_0
    //   455: invokevirtual 37	com/tencent/aelight/camera/ae/play/AECoverSelectFragment:getBaseActivity	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   458: invokevirtual 377	com/tencent/mobileqq/app/BaseActivity:finish	()V
    //   461: aload 5
    //   463: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	AECoverSelectFragment
    //   29	7	1	d	double
    //   16	301	3	f1	float
    //   12	15	4	f2	float
    //   49	302	5	localObject1	Object
    //   377	1	5	localObject2	Object
    //   382	80	5	localException	java.lang.Exception
    //   77	344	6	localObject3	Object
    //   209	33	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   70	241	377	finally
    //   241	257	377	finally
    //   257	355	377	finally
    //   358	374	377	finally
    //   384	436	377	finally
    //   70	241	382	java/lang/Exception
    //   241	257	382	java/lang/Exception
    //   257	355	382	java/lang/Exception
    //   358	374	382	java/lang/Exception
  }
  
  private void setSystemBarComp()
  {
    if (((getActivity() instanceof QBaseActivity)) && (((QBaseActivity)getActivity()).getSystemBarComp() != null))
    {
      ((QBaseActivity)getActivity()).getSystemBarComp().init();
      ((QBaseActivity)getActivity()).getSystemBarComp().setStatusBarColor(-1);
      ((QBaseActivity)getActivity()).getSystemBarComp().setStatusBarDrawable(null);
    }
  }
  
  void bindViews(View paramView)
  {
    this.tavCutVideoView = ((TAVCutVideoView)paramView.findViewById(2063991469));
    this.llBottomContainer = ((LinearLayout)paramView.findViewById(2063991223));
    this.flCoverSelectContainer = ((FrameLayout)paramView.findViewById(2063991087));
    this.tvCancel = ((TextView)paramView.findViewById(2063991524));
    this.tvConfirm = ((TextView)paramView.findViewById(2063991527));
    this.tvCancel.setOnClickListener(this);
    this.tvConfirm.setOnClickListener(this);
  }
  
  void customizeBindingData(VideoResourceModel paramVideoResourceModel)
  {
    addCoverSelectView();
    this.coverVideoSession = new TAVCutVideoSession();
    AEEditorVideoEditFragment.a(getActivity(), this.coverVideoSession, ParamFactory.c(), this.tavCutVideoSession.getMediaModel(), null, null);
    this.coverVideoSession.restoreStickersWithLyric(new ArrayList(this.tavCutVideoSession.getMediaModel().getMediaEffectModel().getStickerModelList()));
    this.coverVideoSession.setStickerTouchEnable(false);
    if (ModelExtKt.isLightTemplate(this.coverVideoSession.getMediaModel())) {
      this.coverVideoSession.getMediaModel().getMediaEffectModel().setAeKitModel(null);
    }
    this.coverSelectView.bindPlayer(this.mMoviePlayer);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initTavCutAndPlayer: \nresource.selectDuration = ");
    ((StringBuilder)localObject).append(paramVideoResourceModel.getSelectTimeDuration());
    ((StringBuilder)localObject).append("\nresource.start = ");
    ((StringBuilder)localObject).append(paramVideoResourceModel.getSelectTimeStart());
    ((StringBuilder)localObject).append("\n resource.end = ");
    ((StringBuilder)localObject).append(paramVideoResourceModel.getSelectTimeStart() + paramVideoResourceModel.getSelectTimeDuration());
    Log.d("AECoverSelectFragment", ((StringBuilder)localObject).toString());
    this.coverSelectView.updateTavVideoSession(this.coverVideoSession);
    localObject = this.coverSelectView;
    float f = paramVideoResourceModel.getSpeed();
    long l1 = getTotalDuration(paramVideoResourceModel);
    long l2 = paramVideoResourceModel.getSelectTimeStart();
    long l3 = paramVideoResourceModel.getSelectTimeStart();
    ((CoverSelectView)localObject).setClipAndSpeed(f, l1, l2, getTotalDuration(paramVideoResourceModel) + l3);
    this.mMoviePlayer.pause();
    paramVideoResourceModel = CMTime.fromUs(((float)this.tavCutVideoSession.getDuration().getTimeUs() * this.defaultCoverProgress / 100.0F));
    this.mMoviePlayer.seekToTime(paramVideoResourceModel);
  }
  
  protected int getLayoutId()
  {
    return 2064056428;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2063991524)
    {
      if (i != 2063991527) {
        return;
      }
      saveDataAndQuit();
      return;
    }
    getBaseActivity().setResult(0);
    getBaseActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setSystemBarComp();
    ImmersiveUtils.setStatusTextColor(QQTheme.isNowThemeIsNight() ^ true, getActivity().getWindow());
    this.defaultCoverProgress = getDefaultCoverProgress();
    paramBundle = new StringBuilder();
    paramBundle.append("[coverGen][onCreate] missionId = ");
    paramBundle.append(this.missionId);
    AEQLog.a("AECoverSelectFragment", paramBundle.toString());
    paramBundle = AEEditorProcessManager.a().c(this.missionId);
    if ((paramBundle != null) && (!paramBundle.g.equals("AEEDITOR_GENERATE_STATUS_READY")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[coverGen][onCreate][tryToKillExport] videoInfo = ");
      localStringBuilder.append(paramBundle.toString());
      AEQLog.a("AECoverSelectFragment", localStringBuilder.toString());
      if (paramBundle.i.a() != null) {
        paramBundle.i.a().cancel();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056428, paramViewGroup, false);
  }
  
  public void onFinish()
  {
    this.coverVideoSession.release();
    this.coverSelectView.release();
    AEEditorVideoInfo localAEEditorVideoInfo = AEEditorProcessManager.a().c(this.missionId);
    if ((localAEEditorVideoInfo != null) && (localAEEditorVideoInfo.g.equals("AEEDITOR_GENERATE_STATUS_CANEL"))) {
      AEEditorProcessManager.a().a(this.missionId);
    }
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    long l = ((float)this.tavCutVideoSession.getDuration().getTimeUs() * this.coverSelectView.getCurrCoverProgress() / 100.0F);
    this.mMoviePlayer.seekToTime(CMTime.fromUs(l));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AECoverSelectFragment
 * JD-Core Version:    0.7.0.1
 */