package com.tencent.biz.qqstory.storyHome;

import ajya;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import auko;
import aukp;
import aukq;
import bcql;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ssf;
import swc;
import tvv;
import uoq;
import ved;
import vwj;

public class VideoEncodeActivity
  extends QQStoryBaseActivity
{
  private static final DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("MM-dd-HHmmSS");
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private String jdField_a_of_type_JavaLangString;
  tvv jdField_a_of_type_Tvv = new tvv();
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private EditText c;
  private EditText d;
  private EditText e;
  
  private static int a(String paramString1, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
    paramString1.a(false);
    paramString1.b(false);
    paramString1.d(paramBoolean);
    if (paramArrayOfByte != null) {
      paramString1.a(paramArrayOfByte, paramInt);
    }
    paramString1.run();
    return paramString1.a;
  }
  
  private List<PublishVideoEntry> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    localObject = swc.a((aukp)localObject, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), null, null);
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
        ved.c("Q.qqstory:VideoEncodeActivity", "user scene " + localPublishVideoEntry);
      }
    }
    return localObject;
  }
  
  private void a()
  {
    Button localButton = (Button)findViewById(2131365006);
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
    //   1: getfield 176	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   4: d2i
    //   5: putstatic 181	axim:y	I
    //   8: aload_1
    //   9: getfield 184	com/tencent/biz/qqstory/database/PublishVideoEntry:recordFrames	I
    //   12: putstatic 187	axim:z	I
    //   15: aload_1
    //   16: getfield 190	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   19: putstatic 193	axim:J	I
    //   22: iconst_0
    //   23: putstatic 196	axim:x	I
    //   26: iconst_0
    //   27: putstatic 199	axim:E	I
    //   30: aload_1
    //   31: getfield 202	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMaxrate	I
    //   34: putstatic 205	axim:r	I
    //   37: aload_1
    //   38: getfield 208	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMinrate	I
    //   41: putstatic 211	axim:s	I
    //   44: bipush 10
    //   46: invokestatic 216	tcz:a	(I)Ltch;
    //   49: checkcast 218	tcs
    //   52: ldc 220
    //   54: bipush 23
    //   56: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokevirtual 229	tcs:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 222	java/lang/Integer
    //   65: invokevirtual 233	java/lang/Integer:intValue	()I
    //   68: putstatic 236	axim:C	I
    //   71: iconst_0
    //   72: putstatic 239	axim:K	I
    //   75: getstatic 27	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:jdField_a_of_type_JavaTextDateFormat	Ljava/text/DateFormat;
    //   78: new 241	java/util/Date
    //   81: dup
    //   82: invokespecial 242	java/util/Date:<init>	()V
    //   85: invokevirtual 248	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   88: astore 7
    //   90: aload_0
    //   91: getfield 250	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:e	Landroid/widget/EditText;
    //   94: invokevirtual 256	android/widget/EditText:getText	()Landroid/text/Editable;
    //   97: invokevirtual 259	java/lang/Object:toString	()Ljava/lang/String;
    //   100: invokevirtual 264	java/lang/String:trim	()Ljava/lang/String;
    //   103: invokevirtual 267	java/lang/String:length	()I
    //   106: ifle +18 -> 124
    //   109: aload_0
    //   110: getfield 250	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:e	Landroid/widget/EditText;
    //   113: invokevirtual 256	android/widget/EditText:getText	()Landroid/text/Editable;
    //   116: invokevirtual 259	java/lang/Object:toString	()Ljava/lang/String;
    //   119: invokevirtual 264	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore 7
    //   124: new 269	java/io/File
    //   127: dup
    //   128: new 139	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   135: getstatic 274	ajsd:aW	Ljava/lang/String;
    //   138: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc_w 276
    //   144: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 7
    //   149: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokespecial 277	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 7
    //   160: aload 7
    //   162: invokevirtual 280	java/io/File:mkdirs	()Z
    //   165: pop
    //   166: ldc 137
    //   168: new 139	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 282
    //   178: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 7
    //   183: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 284	ved:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 286	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:c	Landroid/widget/EditText;
    //   196: invokevirtual 256	android/widget/EditText:getText	()Landroid/text/Editable;
    //   199: invokevirtual 259	java/lang/Object:toString	()Ljava/lang/String;
    //   202: invokestatic 289	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   205: invokevirtual 233	java/lang/Integer:intValue	()I
    //   208: istore_2
    //   209: aload_0
    //   210: getfield 291	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:d	Landroid/widget/EditText;
    //   213: invokevirtual 256	android/widget/EditText:getText	()Landroid/text/Editable;
    //   216: invokevirtual 259	java/lang/Object:toString	()Ljava/lang/String;
    //   219: invokestatic 289	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   222: invokevirtual 233	java/lang/Integer:intValue	()I
    //   225: istore_3
    //   226: iload_2
    //   227: iload_3
    //   228: if_icmpge +196 -> 424
    //   231: invokestatic 297	java/lang/System:currentTimeMillis	()J
    //   234: lstore 5
    //   236: iconst_0
    //   237: putstatic 239	axim:K	I
    //   240: bipush 23
    //   242: putstatic 236	axim:C	I
    //   245: iload_2
    //   246: bipush 30
    //   248: iadd
    //   249: putstatic 300	axim:t	I
    //   252: new 139	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 302
    //   262: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: getstatic 236	axim:C	I
    //   268: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: ldc_w 307
    //   274: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 300	axim:t	I
    //   280: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   283: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore 8
    //   288: new 139	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   295: aload 7
    //   297: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: getstatic 310	java/io/File:separator	Ljava/lang/String;
    //   303: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 8
    //   308: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 312
    //   314: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore 9
    //   322: aload_1
    //   323: getfield 315	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   326: aload_1
    //   327: getfield 319	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   330: aload_1
    //   331: getfield 322	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   334: aload_1
    //   335: getfield 326	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   338: aload 9
    //   340: invokestatic 328	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:a	(Ljava/lang/String;[BIZLjava/lang/String;)I
    //   343: istore 4
    //   345: ldc 137
    //   347: ldc_w 330
    //   350: iload 4
    //   352: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aload 8
    //   357: aload 9
    //   359: invokestatic 335	bbdx:a	(Ljava/lang/String;)J
    //   362: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: invokestatic 343	ved:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   368: iload 4
    //   370: ifeq +19 -> 389
    //   373: aload_0
    //   374: getfield 345	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   377: new 347	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2
    //   380: dup
    //   381: aload_0
    //   382: invokespecial 350	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2:<init>	(Lcom/tencent/biz/qqstory/storyHome/VideoEncodeActivity;)V
    //   385: invokevirtual 354	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   388: pop
    //   389: ldc 137
    //   391: ldc_w 356
    //   394: aload 8
    //   396: invokestatic 297	java/lang/System:currentTimeMillis	()J
    //   399: lload 5
    //   401: lsub
    //   402: invokestatic 340	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: invokestatic 359	ved:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
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
    //   426: putstatic 300	axim:t	I
    //   429: bipush 23
    //   431: putstatic 236	axim:C	I
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
    localRadioGroup.setOnCheckedChangeListener(new uoq(this));
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
      localRadioButton.setTextColor(getResources().getColor(2131165275));
    }
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
    a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    OpenPlayerBuilder.Data localData = (OpenPlayerBuilder.Data)getIntent().getExtras().getSerializable("story_data");
    super.doOnCreate(paramBundle);
    setContentView(2131561402);
    super.setTitle(ajya.a(2131716146));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363643));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131375614));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375613));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131371248));
    this.c = ((EditText)findViewById(2131371249));
    this.d = ((EditText)findViewById(2131371250));
    this.e = ((EditText)findViewById(2131365686));
    d();
    if ((localData != null) && ((localData.mInfo instanceof HomeFeedPlayInfo))) {
      this.jdField_a_of_type_Tvv.a((HomeFeedPlayInfo)localData.mInfo);
    }
    for (;;)
    {
      return true;
      if ((localData != null) && ((localData.mInfo instanceof MsgTabPlayInfo))) {
        this.jdField_a_of_type_Tvv.a((MsgTabPlayInfo)localData.mInfo);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 20000)
    {
      paramIntent = QQStoryContext.a().a().createEntityManager();
      localObject = paramIntent.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        break label73;
      }
      ved.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: 0");
    }
    for (;;)
    {
      return;
      label73:
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
        ved.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s", new Object[] { localPublishVideoEntry.fakeVid, Integer.valueOf(localPublishVideoEntry.publishState), localPublishVideoEntry.videoLabel, localPublishVideoEntry.videoDoodleDescription, Long.valueOf(localPublishVideoEntry.videoDuration), localPublishVideoEntry.videoLocationDescription });
        localPublishVideoEntry.publishState = 0;
        localPublishVideoEntry.setStatus(1000);
        paramIntent.b(localPublishVideoEntry);
        this.jdField_a_of_type_JavaLangString = localPublishVideoEntry.fakeVid;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
  }
  
  public void onClickDeleteSence(View paramView)
  {
    paramView = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    Object localObject = swc.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.jdField_b_of_type_JavaLangString });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).setStatus(1001);
      paramView.b((auko)localObject);
      d();
    }
  }
  
  public void onClickSaveScene(View paramView)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString())) {
      bcql.a(this, ajya.a(2131716148), 0).a();
    }
    paramView = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    Object localObject = swc.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.jdField_a_of_type_JavaLangString });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).name = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
      ((PublishVideoEntry)localObject).setStatus(1000);
      paramView.b((auko)localObject);
      d();
    }
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void onClickStartCompress(View paramView)
  {
    a(ajya.a(2131716147));
    new File(ssf.e).mkdirs();
    new StringBuilder().append(ssf.e).append(System.currentTimeMillis()).append(".mp4").toString();
    paramView = swc.a(this.jdField_b_of_type_JavaLangString);
    new swc();
    ThreadManager.newFreeThread(new VideoEncodeActivity.1(this, paramView), "VideoComposite", 5).start();
  }
  
  public void onClickTakePic(View paramView)
  {
    vwj.a().a(this, null, 20000);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.jdField_a_of_type_Tvv.onClickTestDown(paramView);
  }
  
  public void onClickTestInit(View paramView) {}
  
  public void onClickTestUp(View paramView)
  {
    this.jdField_a_of_type_Tvv.onClickTestUp(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity
 * JD-Core Version:    0.7.0.1
 */