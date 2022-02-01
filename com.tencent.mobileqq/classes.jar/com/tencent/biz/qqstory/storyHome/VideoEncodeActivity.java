package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.playvideo.dataprovider.DataProviderTest2;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoEncodeActivity
  extends QQStoryBaseActivity
{
  private static final DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("MM-dd-HHmmSS");
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  DataProviderTest2 jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderDataProviderTest2 = new DataProviderTest2();
  private String jdField_a_of_type_JavaLangString;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private EditText c;
  private EditText d;
  private EditText e;
  
  private static int a(String paramString1, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
    paramString1.setEnableHardEncode(false);
    paramString1.setEnableDeleteCache(false);
    paramString1.setMuteVoice(paramBoolean);
    if (paramArrayOfByte != null) {
      paramString1.setMosaicMask(paramArrayOfByte, paramInt);
    }
    paramString1.run();
    return paramString1.errorCode;
  }
  
  private List<PublishVideoEntry> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    localObject = VideoCompositeHelper.a((EntityManager)localObject, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return new ArrayList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
      if (TextUtils.isEmpty(localPublishVideoEntry.name)) {
        localIterator.remove();
      } else {
        SLog.c("Q.qqstory:VideoEncodeActivity", "user scene " + localPublishVideoEntry);
      }
    }
    return localObject;
  }
  
  private void a()
  {
    Button localButton = (Button)findViewById(2131365661);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localButton.setEnabled(false);
      return;
    }
    localButton.setEnabled(true);
  }
  
  /* Error */
  private void a(PublishVideoEntry paramPublishVideoEntry)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 181	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   4: d2i
    //   5: putstatic 186	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mRecordTime	I
    //   8: aload_1
    //   9: getfield 189	com/tencent/biz/qqstory/database/PublishVideoEntry:recordFrames	I
    //   12: putstatic 192	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mRecordFrames	I
    //   15: aload_1
    //   16: getfield 195	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   19: putstatic 198	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mSaveMode	I
    //   22: iconst_0
    //   23: putstatic 201	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mIsSmooth	I
    //   26: iconst_0
    //   27: putstatic 204	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mEnableTotalTimeAdjust	I
    //   30: aload_1
    //   31: getfield 207	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMaxrate	I
    //   34: putstatic 210	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mMaxrate	I
    //   37: aload_1
    //   38: getfield 213	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMinrate	I
    //   41: putstatic 216	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mMinrate	I
    //   44: bipush 10
    //   46: invokestatic 221	com/tencent/biz/qqstory/model/SuperManager:a	(I)Lcom/tencent/biz/qqstory/model/IManager;
    //   49: checkcast 223	com/tencent/biz/qqstory/model/StoryConfigManager
    //   52: ldc 225
    //   54: bipush 23
    //   56: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokevirtual 234	com/tencent/biz/qqstory/model/StoryConfigManager:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 227	java/lang/Integer
    //   65: invokevirtual 238	java/lang/Integer:intValue	()I
    //   68: putstatic 241	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mCRFValue	I
    //   71: iconst_0
    //   72: putstatic 244	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mBitrateMode	I
    //   75: getstatic 27	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:jdField_a_of_type_JavaTextDateFormat	Ljava/text/DateFormat;
    //   78: new 246	java/util/Date
    //   81: dup
    //   82: invokespecial 247	java/util/Date:<init>	()V
    //   85: invokevirtual 253	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   88: astore 7
    //   90: aload_0
    //   91: getfield 255	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:e	Landroid/widget/EditText;
    //   94: invokevirtual 261	android/widget/EditText:getText	()Landroid/text/Editable;
    //   97: invokevirtual 264	java/lang/Object:toString	()Ljava/lang/String;
    //   100: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   103: invokevirtual 272	java/lang/String:length	()I
    //   106: ifle +18 -> 124
    //   109: aload_0
    //   110: getfield 255	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:e	Landroid/widget/EditText;
    //   113: invokevirtual 261	android/widget/EditText:getText	()Landroid/text/Editable;
    //   116: invokevirtual 264	java/lang/Object:toString	()Ljava/lang/String;
    //   119: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore 7
    //   124: new 274	java/io/File
    //   127: dup
    //   128: new 144	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   135: getstatic 279	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   138: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 281
    //   144: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 7
    //   149: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 282	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 7
    //   160: aload 7
    //   162: invokevirtual 285	java/io/File:mkdirs	()Z
    //   165: pop
    //   166: ldc 142
    //   168: new 144	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 287
    //   178: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 7
    //   183: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 289	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 291	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:c	Landroid/widget/EditText;
    //   196: invokevirtual 261	android/widget/EditText:getText	()Landroid/text/Editable;
    //   199: invokevirtual 264	java/lang/Object:toString	()Ljava/lang/String;
    //   202: invokestatic 294	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   205: invokevirtual 238	java/lang/Integer:intValue	()I
    //   208: istore_2
    //   209: aload_0
    //   210: getfield 296	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:d	Landroid/widget/EditText;
    //   213: invokevirtual 261	android/widget/EditText:getText	()Landroid/text/Editable;
    //   216: invokevirtual 264	java/lang/Object:toString	()Ljava/lang/String;
    //   219: invokestatic 294	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   222: invokevirtual 238	java/lang/Integer:intValue	()I
    //   225: istore_3
    //   226: iload_2
    //   227: iload_3
    //   228: if_icmpge +196 -> 424
    //   231: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   234: lstore 5
    //   236: iconst_0
    //   237: putstatic 244	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mBitrateMode	I
    //   240: bipush 23
    //   242: putstatic 241	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mCRFValue	I
    //   245: iload_2
    //   246: bipush 30
    //   248: iadd
    //   249: putstatic 305	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mQmax	I
    //   252: new 144	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 307
    //   262: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: getstatic 241	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mCRFValue	I
    //   268: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 312
    //   274: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 305	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mQmax	I
    //   280: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore 8
    //   288: new 144	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   295: aload 7
    //   297: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: getstatic 315	java/io/File:separator	Ljava/lang/String;
    //   303: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 8
    //   308: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 317
    //   314: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore 9
    //   322: aload_1
    //   323: getfield 320	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   326: aload_1
    //   327: getfield 324	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   330: aload_1
    //   331: getfield 327	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   334: aload_1
    //   335: getfield 331	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   338: aload 9
    //   340: invokestatic 333	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:a	(Ljava/lang/String;[BIZLjava/lang/String;)I
    //   343: istore 4
    //   345: ldc 142
    //   347: ldc_w 335
    //   350: iload 4
    //   352: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aload 8
    //   357: aload 9
    //   359: invokestatic 340	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   362: invokestatic 345	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: invokestatic 348	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   368: iload 4
    //   370: ifeq +19 -> 389
    //   373: aload_0
    //   374: getfield 350	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   377: new 352	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2
    //   380: dup
    //   381: aload_0
    //   382: invokespecial 355	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2:<init>	(Lcom/tencent/biz/qqstory/storyHome/VideoEncodeActivity;)V
    //   385: invokevirtual 359	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   388: pop
    //   389: ldc 142
    //   391: ldc_w 361
    //   394: aload 8
    //   396: invokestatic 302	java/lang/System:currentTimeMillis	()J
    //   399: lload 5
    //   401: lsub
    //   402: invokestatic 345	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: invokestatic 364	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   408: iload_2
    //   409: iconst_1
    //   410: iadd
    //   411: istore_2
    //   412: goto -186 -> 226
    //   415: astore 8
    //   417: iconst_0
    //   418: istore_2
    //   419: iconst_0
    //   420: istore_3
    //   421: goto -195 -> 226
    //   424: bipush 31
    //   426: putstatic 305	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mQmax	I
    //   429: bipush 23
    //   431: putstatic 241	com/tencent/mobileqq/shortvideo/mediadevice/CodecParam:mCRFValue	I
    //   434: return
    //   435: astore 8
    //   437: goto -18 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	VideoEncodeActivity
    //   0	440	1	paramPublishVideoEntry	PublishVideoEntry
    //   208	211	2	i	int
    //   225	196	3	j	int
    //   343	26	4	k	int
    //   234	166	5	l	long
    //   88	208	7	localObject	Object
    //   286	109	8	str1	String
    //   415	1	8	localException1	java.lang.Exception
    //   435	1	8	localException2	java.lang.Exception
    //   320	38	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   192	209	415	java/lang/Exception
    //   209	226	435	java/lang/Exception
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
    Object localObject = a();
    if (((List)localObject).size() == 0) {
      return;
    }
    RadioGroup localRadioGroup = new RadioGroup(this);
    localRadioGroup.setOrientation(1);
    localRadioGroup.setOnCheckedChangeListener(new VideoEncodeActivity.3(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRadioGroup);
    RadioButton localRadioButton = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      localRadioButton = new RadioButton(this);
      localRadioGroup.addView(localRadioButton);
      localRadioButton.setText(localPublishVideoEntry.name);
      localRadioButton.setTag(localPublishVideoEntry.fakeVid);
      localRadioButton.setTextColor(getResources().getColor(2131165357));
    }
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
    a();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    OpenPlayerBuilder.Data localData = (OpenPlayerBuilder.Data)getIntent().getExtras().getSerializable("story_data");
    super.doOnCreate(paramBundle);
    setContentView(2131561963);
    super.setTitle(HardCodeUtil.a(2131715964));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364125));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131377492));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377491));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372734));
    this.c = ((EditText)findViewById(2131372735));
    this.d = ((EditText)findViewById(2131372736));
    this.e = ((EditText)findViewById(2131366363));
    d();
    if ((localData != null) && ((localData.mInfo instanceof HomeFeedPlayInfo))) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderDataProviderTest2.a((HomeFeedPlayInfo)localData.mInfo);
    }
    for (;;)
    {
      return true;
      if ((localData != null) && ((localData.mInfo instanceof MsgTabPlayInfo))) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderDataProviderTest2.a((MsgTabPlayInfo)localData.mInfo);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 20000)
    {
      paramIntent = QQStoryContext.a().a().createEntityManager();
      localObject = paramIntent.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        break label73;
      }
      SLog.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: 0");
    }
    for (;;)
    {
      return;
      label73:
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
        SLog.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s", new Object[] { localPublishVideoEntry.fakeVid, Integer.valueOf(localPublishVideoEntry.publishState), localPublishVideoEntry.videoLabel, localPublishVideoEntry.videoDoodleDescription, Long.valueOf(localPublishVideoEntry.videoDuration), localPublishVideoEntry.videoLocationDescription });
        localPublishVideoEntry.publishState = 0;
        localPublishVideoEntry.setStatus(1000);
        paramIntent.persistOrReplace(localPublishVideoEntry);
        this.jdField_a_of_type_JavaLangString = localPublishVideoEntry.fakeVid;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
  }
  
  public void onClickDeleteSence(View paramView)
  {
    paramView = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    Object localObject = VideoCompositeHelper.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.jdField_b_of_type_JavaLangString });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).setStatus(1001);
      paramView.remove((Entity)localObject);
      d();
    }
  }
  
  public void onClickSaveScene(View paramView)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
      QQToast.a(this, HardCodeUtil.a(2131715966), 0).a();
    }
    paramView = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    Object localObject = VideoCompositeHelper.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.jdField_a_of_type_JavaLangString });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).name = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      ((PublishVideoEntry)localObject).setStatus(1000);
      paramView.persistOrReplace((Entity)localObject);
      d();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void onClickStartCompress(View paramView)
  {
    a(HardCodeUtil.a(2131715965));
    new File(QQStoryConstant.e).mkdirs();
    new StringBuilder().append(QQStoryConstant.e).append(System.currentTimeMillis()).append(".mp4").toString();
    paramView = VideoCompositeHelper.a(this.jdField_b_of_type_JavaLangString);
    new VideoCompositeHelper();
    ThreadManager.newFreeThread(new VideoEncodeActivity.1(this, paramView), "VideoComposite", 5).start();
  }
  
  public void onClickTakePic(View paramView)
  {
    StoryPublishLauncher.a().a(this, null, 20000);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderDataProviderTest2.onClickTestDown(paramView);
  }
  
  public void onClickTestInit(View paramView) {}
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderDataProviderTest2.onClickTestUp(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity
 * JD-Core Version:    0.7.0.1
 */