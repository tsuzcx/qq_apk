import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3;
import com.tencent.mobileqq.structmsg.view.TitledImageView;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoInfo.VideoRemark;
import cooperation.qzone.model.VideoUrl;
import cooperation.qzone.model.WeishiFeedCommInfo;
import cooperation.qzone.model.WeishiFeedInfo;
import cooperation.qzone.model.WeishiUserInfo;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

public class bdaz
  extends bcvs
{
  protected View.OnClickListener a;
  public bdbh a;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String aa;
  public String ab;
  public String ac;
  public String ad;
  public String ae;
  public String af;
  public String ag;
  public String ah;
  public String ai;
  String aj = "";
  String ak = "";
  String aq = "";
  String ar = "";
  String as;
  String at;
  String au;
  String av;
  private View.OnClickListener b = new bdba(this);
  public boolean b;
  public long c;
  public boolean c;
  boolean d;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  
  public bdaz()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdbd(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdbe(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 17;
  }
  
  public bdaz(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdbd(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdbe(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.aa = paramString1;
    this.v = paramInt1;
    this.ac = paramString2;
    this.ad = paramString3;
    this.ae = paramString4;
    this.q = paramInt2;
    this.p = paramInt3;
    this.r = paramInt4;
    this.s = paramInt5;
    this.t = paramInt6;
    this.af = paramString5;
    this.ag = paramString6;
    this.ah = paramString7;
    this.jdField_c_of_type_Long = paramLong;
    this.u = paramInt7;
    this.jdField_a_of_type_Int = 17;
  }
  
  public bdaz(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new bdbd(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bdbe(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.aa = paramString1;
    this.ab = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.o = i;
      this.jdField_a_of_type_Int = 17;
      return;
      i = 0;
    }
  }
  
  private Intent a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.getLong("uin");
    String str1 = paramJSONObject.getString("ugcKey");
    Object localObject = paramJSONObject.getString("videoUrl");
    String str2 = paramJSONObject.getString("videoID");
    String str3 = paramJSONObject.getString("nickname");
    String str4 = paramJSONObject.getString("isTXVideo");
    int i = paramJSONObject.getInt("appid");
    paramJSONObject = new WeishiFeedInfo();
    paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
    paramJSONObject.feedCommInfo = new WeishiFeedCommInfo(i, str1, null, null, null);
    paramJSONObject.videoInfo = new VideoInfo();
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelPictureUrl = new PictureUrl(this.aa, this.r, this.s);
    paramJSONObject.videoInfo.jdField_d_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoUrl = new VideoUrl((String)localObject);
    paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark = new VideoInfo.VideoRemark();
    if ("0".equals(str4)) {}
    for (paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 0;; paramJSONObject.videoInfo.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark.b = 1)
    {
      paramJSONObject.videoInfo.g = this.r;
      paramJSONObject.videoInfo.h = this.s;
      paramJSONObject.videoInfo.jdField_a_of_type_JavaLangString = str2;
      paramJSONObject.videoInfo.b = this.t;
      paramJSONObject.userInfo = new WeishiUserInfo(l, str3);
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramJSONObject);
      paramJSONObject = new Intent(BaseApplicationImpl.getContext(), QzoneVerticalVideoDownloadActivity.class);
      paramJSONObject.putExtra("key_plugin_id", "qzone_vertical_video_plugin.apk");
      paramJSONObject.setFlags(268435456);
      paramJSONObject.putExtra("key_weishi_entrance_type", 2);
      paramJSONObject.putParcelableArrayListExtra("key_videolist", (ArrayList)localObject);
      paramJSONObject.putExtra("key_current_feeduin", String.valueOf(l));
      paramJSONObject.putExtra("key_weishi_feeds_id", str1);
      paramJSONObject.putExtra("key_weishi_feed_appid", i);
      paramJSONObject.putExtra("key_weishi_entrance_type", 22);
      return paramJSONObject;
    }
  }
  
  private void a(Context paramContext)
  {
    if ((TextUtils.isEmpty(b())) || ((!b().startsWith("http://")) && (!b().startsWith("https://")))) {}
    do
    {
      do
      {
        return;
        Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", b());
        tzo.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = bcvw.a(b());
    } while (TextUtils.isEmpty(paramContext));
    bcst.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.o == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839400);
      }
      if (this.jdField_a_of_type_Bdbh == null) {
        this.jdField_a_of_type_Bdbh = new bdbh(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.ab);
  }
  
  private void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("file_send_path", paramString);
    localBundle.putInt("video_play_caller", 1);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    paramString = new Intent(paramContext, ShortVideoPlayActivity.class);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
    if (!TextUtils.isEmpty(b()))
    {
      paramContext = bcvw.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        bcst.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
      }
    }
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (a())
    {
      localBundle.putBoolean("is_public_account_video_msg", true);
      this.jdField_a_of_type_Boolean = true;
      this.ai = localBundle.getString("public_account_video_title");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasFlag(4)) {}
    for (boolean bool1 = true; !this.jdField_a_of_type_Boolean; bool1 = false) {
      return b(paramContext, paramView, localBundle);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_UIN") == null) {
        break label262;
      }
      this.af = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.ag = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.ag = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.aj = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.ak = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.aq = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.ar = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131377940) != null)
      {
        paramContext = paramView.getTag(2131377940);
        if ((paramContext instanceof bdbg))
        {
          paramContext = (bdbg)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.af = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131377940);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131718238));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int j;
    int k;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.r >= this.s)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.i = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130843178);
        ((ImageView)localObject2).setVisibility(8);
        i = afur.a(62.0F, (Resources)localObject1);
        if (bool1) {
          i = afur.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i, i);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i = afur.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1351;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131377940);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131377940);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131377940);
        if (!bool1) {
          break label1361;
        }
        i = afur.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1429;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1374;
        }
        j = afur.a(10.0F, (Resources)localObject1) + i;
        k = i;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(k, i, j, i);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131377939);
      ((TextView)localObject4).setTextColor(-1);
      ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject4).setSingleLine(true);
      label753:
      Object localObject5;
      if (bool1)
      {
        ((TextView)localObject4).setTextSize(1, 14.0F);
        localObject5 = new LinearLayout.LayoutParams(0, -2);
        ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject5).rightMargin = afur.a(7.0F, (Resources)localObject1);
        ((LinearLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setSingleLine(true);
        if (!bool1) {
          break label1406;
        }
        ((TextView)localObject1).setTextSize(1, 12.0F);
        label823:
        ((TextView)localObject1).setTextColor(-1);
        localObject5 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject5).gravity = 85;
        ((LinearLayout.LayoutParams)localObject5).weight = 0.0F;
        ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject5);
        localObject5 = new bdbg();
        ((bdbg)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((bdbg)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((bdbg)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        ((bdbg)localObject5).b = ((TextView)localObject1);
        ((bdbg)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131377940, localObject5);
        paramView.setTag(this);
        ((bdbg)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (bdbg)localObject5);
        boolean bool2 = bcvn.a().a(paramContext, 3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.ac);
        }
        if ((bool2) && (this.v != 4)) {
          break label1418;
        }
        ((bdbg)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      for (;;)
      {
        if (this.q > 0) {
          ((bdbg)localObject5).b.setText(ShortVideoUtils.a(this.q * 1000));
        }
        if (!TextUtils.isEmpty(this.as)) {
          paramView.setTag(2131377946, this.as);
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
        }
        return paramView;
        paramBundle.i = false;
        paramBundle.jdField_c_of_type_Boolean = false;
        localObject3 = ShortVideoUtils.a(this.r, this.s);
        ((RelativeLayout.LayoutParams)localObject2).width = localObject3[0];
        ((RelativeLayout.LayoutParams)localObject2).height = localObject3[1];
        break;
        if (!this.jdField_c_of_type_Boolean) {
          paramBundle.setRadiusTop(5.0F);
        }
        for (;;)
        {
          paramBundle.i = true;
          paramBundle.jdField_c_of_type_Boolean = false;
          paramBundle.b(true);
          paramBundle.d(false);
          if (this.r >= this.s) {
            break label1270;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1270:
        if (this.r > this.s)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.r == this.s) && (this.r != 0) && (this.s != 0))
        {
          if (bool1)
          {
            paramBundle.f = PAVideoView.e;
            break;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
        }
        paramBundle.f = PAVideoView.jdField_c_of_type_Int;
        break;
        label1351:
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i;
        break label547;
        label1361:
        i = afur.a(12.0F, (Resources)localObject1);
        break label628;
        label1374:
        k = afur.a(10.0F, (Resources)localObject1) + i;
        j = i;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1406:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label823;
        label1418:
        ((bdbg)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
      }
      label1429:
      j = i;
      k = i;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {}
    label156:
    label834:
    label858:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((sgc.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.d())))
        {
          QQToast.a(paramContext, 2131695235, 1).b(paramContext.getResources().getDimensionPixelSize(2131298998));
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("structmsg.StructMsgItemVideo", 2, "enterFullScreenActivity():", localException);
          }
          localObject = null;
        }
        if (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mQzoneExtraMsg))
        {
          a((QQAppInterface)localObject, paramContext, paramStructMsgForGeneralShare.mQzoneExtraMsg);
          return;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.af);
        if (this.v <= 1) {
          break label834;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.ar);
      localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl)) {
        localBundle.putString("RED_PACKET_ID", Uri.parse(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl).getQueryParameter("redpackid"));
      }
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (Object localObject = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; localObject = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", (String)localObject);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.t));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.r));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.s));
        localBundle.putString("VIDEO_VID", this.ad);
        localBundle.putString("VIDEO_COVER", this.aa);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.ah);
        localBundle.putString("VIDEO_TITLE", this.ai);
        boolean bool1 = true;
        if ((this.v == 2) || (this.v == 3)) {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.v);
        if (b())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.u);
          localBundle.putLong("VIDEO_FEED_ID", this.jdField_c_of_type_Long);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.aj);
          localBundle.putString("VIDEO_THIRD_NAME", this.ak);
          localBundle.putString("VIDEO_THIRD_ACTION", this.aq);
          if (this.v == 2)
          {
            slm.a();
            localBundle.putString("VIDEO_THIRD_URL", slm.a(this.ad));
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
          bcst.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.ac, "" + this.v, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 0);
        localObject = Aladdin.getConfig(261);
        if (((paramStructMsgForGeneralShare.mSourceName == null) || (!paramStructMsgForGeneralShare.mSourceName.equals(anni.a(2131715711)))) && (((AladdinConfig)localObject).getIntegerFromString("enable_floating_layer_style", 0) == 1) && (bmqh.a(paramContext, this.ah, localBundle))) {
          break;
        }
        bool1 = false;
        try
        {
          boolean bool2 = piv.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label788;
        }
        if (!bool1) {
          break label858;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        sia.a(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772037, 2130772039);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.ag);
        break label156;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    label788:
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772037, 2130772039);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      paramQQAppInterface = new JSONObject(paramString);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.optInt("enterVideoLayer") == 1))
      {
        QLog.d("structmsg.StructMsgItemVideo", 2, "[enterQzoneFullScreen] rays, qzShareMsg=" + paramQQAppInterface.toString());
        paramQQAppInterface = a(paramQQAppInterface);
        BaseApplicationImpl.getContext().startActivity(paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("structmsg.StructMsgItemVideo", 1, "[enterQzoneFullScreen] rays", paramQQAppInterface);
    }
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.aa = paramObjectInput.readUTF();
    this.ab = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.o = Integer.parseInt(str);
      if (this.jdField_a_of_type_Int >= 7)
      {
        this.ac = paramObjectInput.readUTF();
        this.ad = paramObjectInput.readUTF();
        this.q = paramObjectInput.readInt();
        this.r = paramObjectInput.readInt();
        this.s = paramObjectInput.readInt();
        this.t = paramObjectInput.readInt();
        this.ae = paramObjectInput.readUTF();
        this.v = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 8) {
        this.ah = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        this.as = paramObjectInput.readUTF();
        this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
      }
      if (this.jdField_a_of_type_Int >= 10) {
        this.p = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.at = paramObjectInput.readUTF();
        this.au = paramObjectInput.readUTF();
        this.av = paramObjectInput.readUTF();
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        this.u = paramObjectInput.readInt();
        this.jdField_c_of_type_Long = paramObjectInput.readLong();
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        this.q = paramObjectInput.readUTF();
        this.B = paramObjectInput.readUTF();
        this.jdField_c_of_type_Int = paramObjectInput.readInt();
        this.r = paramObjectInput.readUTF();
        this.s = paramObjectInput.readUTF();
        this.t = paramObjectInput.readUTF();
        this.u = paramObjectInput.readUTF();
        this.v = paramObjectInput.readUTF();
        this.jdField_d_of_type_Int = paramObjectInput.readInt();
        this.w = paramObjectInput.readUTF();
        this.x = paramObjectInput.readUTF();
        this.y = paramObjectInput.readUTF();
        this.z = paramObjectInput.readUTF();
        this.A = paramObjectInput.readUTF();
        this.e = paramObjectInput.readInt();
        this.C = paramObjectInput.readUTF();
        this.D = paramObjectInput.readUTF();
        this.E = paramObjectInput.readUTF();
        this.F = paramObjectInput.readUTF();
        this.G = paramObjectInput.readUTF();
        this.H = paramObjectInput.readUTF();
        this.I = paramObjectInput.readUTF();
        this.J = paramObjectInput.readUTF();
        this.N = paramObjectInput.readUTF();
        this.O = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 14) {
        this.f = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 15)
      {
        this.g = paramObjectInput.readInt();
        this.h = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 16)
      {
        this.P = paramObjectInput.readUTF();
        this.Q = paramObjectInput.readUTF();
        this.R = paramObjectInput.readUTF();
        this.i = paramObjectInput.readInt();
        this.j = paramObjectInput.readInt();
        this.k = paramObjectInput.readInt();
        this.l = paramObjectInput.readInt();
        this.S = paramObjectInput.readUTF();
        this.T = paramObjectInput.readUTF();
        this.U = paramObjectInput.readUTF();
        this.V = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 17) {
        this.W = paramObjectInput.readUTF();
      }
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.aa).append("\n");
        paramObjectInput.append("videoUrl:").append(this.ab).append("\n");
        paramObjectInput.append("vInfo:").append(this.ac).append("\n");
        paramObjectInput.append("tInfo:").append(this.ad).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.q).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.r).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.s).append("\n");
        paramObjectInput.append("type:").append(this.v).append("\n");
        paramObjectInput.append("articleID").append(this.ah).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.as).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.p).append("\n");
        if ((this.jdField_a_of_type_Int >= 12) && (b()))
        {
          paramObjectInput.append("feedId:").append(this.jdField_c_of_type_Long).append("\n");
          paramObjectInput.append("feedType:").append(this.u).append("\n");
        }
        paramObjectInput.append("]:").append("\n");
        QLog.d("structmsg.StructMsgItemVideo", 2, paramObjectInput.toString());
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        this.o = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.aa != null)
    {
      str = this.aa;
      paramObjectOutput.writeUTF(str);
      if (this.ab == null) {
        break label1048;
      }
      str = this.ab;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.o + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.ac == null) {
          break label1054;
        }
        str = this.ac;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.ad == null) {
          break label1060;
        }
        str = this.ad;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.q);
        paramObjectOutput.writeInt(this.r);
        paramObjectOutput.writeInt(this.s);
        paramObjectOutput.writeInt(this.t);
        if (this.ae == null) {
          break label1066;
        }
        str = this.ae;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.v);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.ah == null) {
          break label1072;
        }
        str = this.ah;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.as == null) {
          break label1078;
        }
        str = this.as;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label1084;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.p);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.at == null) {
          break label1090;
        }
        str = this.at;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.au == null) {
          break label1096;
        }
        str = this.au;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.av == null) {
          break label1102;
        }
        str = this.av;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectOutput.writeInt(this.u);
        paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        if (this.q == null) {
          break label1108;
        }
        str = this.q;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.B == null) {
          break label1114;
        }
        str = this.B;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label1120;
        }
        str = "0";
        label449:
        paramObjectOutput.writeUTF(str);
        if (this.s != null) {
          break label1128;
        }
        str = "0";
        label466:
        paramObjectOutput.writeUTF(str);
        if (this.t != null) {
          break label1136;
        }
        str = "";
        label483:
        paramObjectOutput.writeUTF(str);
        if (this.u != null) {
          break label1144;
        }
        str = "";
        label500:
        paramObjectOutput.writeUTF(str);
        if (this.v != null) {
          break label1152;
        }
        str = "";
        label517:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label1160;
        }
        str = "";
        label544:
        paramObjectOutput.writeUTF(str);
        if (this.x != null) {
          break label1168;
        }
        str = "";
        label561:
        paramObjectOutput.writeUTF(str);
        if (this.y != null) {
          break label1176;
        }
        str = "";
        label578:
        paramObjectOutput.writeUTF(str);
        if (this.z != null) {
          break label1184;
        }
        str = "";
        label595:
        paramObjectOutput.writeUTF(str);
        if (this.A != null) {
          break label1192;
        }
        str = "";
        label612:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.e);
        if (this.C != null) {
          break label1200;
        }
        str = "";
        label639:
        paramObjectOutput.writeUTF(str);
        if (this.D != null) {
          break label1208;
        }
        str = "";
        label656:
        paramObjectOutput.writeUTF(str);
        if (this.E != null) {
          break label1216;
        }
        str = "";
        label673:
        paramObjectOutput.writeUTF(str);
        if (this.F != null) {
          break label1224;
        }
        str = "";
        label690:
        paramObjectOutput.writeUTF(str);
        if (this.G != null) {
          break label1232;
        }
        str = "";
        label707:
        paramObjectOutput.writeUTF(str);
        if (this.H != null) {
          break label1240;
        }
        str = "";
        label724:
        paramObjectOutput.writeUTF(str);
        if (this.I != null) {
          break label1248;
        }
        str = "";
        label741:
        paramObjectOutput.writeUTF(str);
        if (this.J != null) {
          break label1256;
        }
        str = "";
        label758:
        paramObjectOutput.writeUTF(str);
        if (this.N != null) {
          break label1264;
        }
        str = "";
        label775:
        paramObjectOutput.writeUTF(str);
        if (this.O != null) {
          break label1272;
        }
        str = "";
        label792:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 14) {
        paramObjectOutput.writeInt(this.f);
      }
      if (this.jdField_a_of_type_Int >= 15)
      {
        paramObjectOutput.writeInt(this.g);
        paramObjectOutput.writeInt(this.h);
      }
      if (this.jdField_a_of_type_Int >= 16)
      {
        if (this.P != null) {
          break label1280;
        }
        str = "";
        label866:
        paramObjectOutput.writeUTF(str);
        if (this.Q != null) {
          break label1288;
        }
        str = "";
        label883:
        paramObjectOutput.writeUTF(str);
        if (this.R != null) {
          break label1296;
        }
        str = "";
        label900:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.i);
        paramObjectOutput.writeInt(this.j);
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        if (this.S != null) {
          break label1304;
        }
        str = "";
        label957:
        paramObjectOutput.writeUTF(str);
        if (this.T != null) {
          break label1312;
        }
        str = "";
        label974:
        paramObjectOutput.writeUTF(str);
        if (this.U != null) {
          break label1320;
        }
        str = "";
        label991:
        paramObjectOutput.writeUTF(str);
        if (this.V != null) {
          break label1328;
        }
        str = "";
        label1008:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 17) {
        if (this.W != null) {
          break label1336;
        }
      }
    }
    label1048:
    label1054:
    label1060:
    label1066:
    label1072:
    label1078:
    label1336:
    for (String str = "";; str = this.W)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label92;
      str = "";
      break label111;
      str = "";
      break label170;
      str = "";
      break label208;
      str = "";
      break label236;
      label1084:
      str = "0";
      break label254;
      label1090:
      str = "";
      break label301;
      label1096:
      str = "";
      break label320;
      label1102:
      str = "";
      break label339;
      label1108:
      str = "";
      break label403;
      label1114:
      str = "";
      break label422;
      label1120:
      str = this.r;
      break label449;
      label1128:
      str = this.s;
      break label466;
      label1136:
      str = this.t;
      break label483;
      label1144:
      str = this.u;
      break label500;
      str = this.v;
      break label517;
      str = this.w;
      break label544;
      str = this.x;
      break label561;
      str = this.y;
      break label578;
      str = this.z;
      break label595;
      str = this.A;
      break label612;
      str = this.C;
      break label639;
      label1208:
      str = this.D;
      break label656;
      label1216:
      str = this.E;
      break label673;
      label1224:
      str = this.F;
      break label690;
      label1232:
      str = this.G;
      break label707;
      label1240:
      str = this.H;
      break label724;
      label1248:
      str = this.I;
      break label741;
      label1256:
      str = this.J;
      break label758;
      label1264:
      str = this.N;
      break label775;
      label1272:
      str = this.O;
      break label792;
      str = this.P;
      break label866;
      str = this.Q;
      break label883;
      str = this.R;
      break label900;
      str = this.S;
      break label957;
      str = this.T;
      break label974;
      str = this.U;
      break label991;
      str = this.V;
      break label1008;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.aa)) {
      paramXmlSerializer.attribute(null, "cover", this.aa);
    }
    if (!TextUtils.isEmpty(this.ab)) {
      paramXmlSerializer.attribute(null, "src", this.ab);
    }
    if (!TextUtils.isEmpty(this.ac)) {
      paramXmlSerializer.attribute(null, "vInfo", this.ac);
    }
    if (!TextUtils.isEmpty(this.ad)) {
      paramXmlSerializer.attribute(null, "tInfo", this.ad);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.p));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.q));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.r));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.s));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.t));
    if (!TextUtils.isEmpty(this.ae)) {
      paramXmlSerializer.attribute(null, "summary", this.ae);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.v));
    if (!TextUtils.isEmpty(this.ah)) {
      paramXmlSerializer.attribute(null, "aID", this.ah);
    }
    if (this.o == 1) {
      paramXmlSerializer.attribute(null, "load", this.o + "");
    }
    if (!TextUtils.isEmpty(this.as)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.as);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.at)) {
        paramXmlSerializer.attribute(null, "apurl", this.at);
      }
      if (!TextUtils.isEmpty(this.au)) {
        paramXmlSerializer.attribute(null, "rl", this.au);
      }
      if (!TextUtils.isEmpty(this.av)) {
        paramXmlSerializer.attribute(null, "disType", this.av);
      }
      if (this.jdField_c_of_type_Long != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.jdField_c_of_type_Long));
      }
      if (this.u != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.u));
      }
      if (this.jdField_c_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "action_type", String.valueOf(this.jdField_c_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.r)) {
        paramXmlSerializer.attribute(null, "advertiser_id", this.r);
      }
      if (!TextUtils.isEmpty(this.s)) {
        paramXmlSerializer.attribute(null, "aid", this.s);
      }
      if (!TextUtils.isEmpty(this.t)) {
        paramXmlSerializer.attribute(null, "app_download_schema", this.t);
      }
      if (!TextUtils.isEmpty(this.u)) {
        paramXmlSerializer.attribute(null, "canvas_json", this.u);
      }
      if (!TextUtils.isEmpty(this.v)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.v);
      }
      if (this.jdField_d_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "dest_type", String.valueOf(this.jdField_d_of_type_Int));
      }
      if (!TextUtils.isEmpty(this.w)) {
        paramXmlSerializer.attribute(null, "effect_url", this.w);
      }
      if (!TextUtils.isEmpty(this.x)) {
        paramXmlSerializer.attribute(null, "landing_page", this.x);
      }
      if (!TextUtils.isEmpty(this.y)) {
        paramXmlSerializer.attribute(null, "landing_page_report_url", this.y);
      }
      if (!TextUtils.isEmpty(this.z)) {
        paramXmlSerializer.attribute(null, "noco_id", this.z);
      }
      if (!TextUtils.isEmpty(this.A)) {
        paramXmlSerializer.attribute(null, "product_id", this.A);
      }
      if (!TextUtils.isEmpty(this.q)) {
        paramXmlSerializer.attribute(null, "apurl", this.q);
      }
      if (this.e != 0) {
        paramXmlSerializer.attribute(null, "product_type", String.valueOf(this.e));
      }
      if (this.f != 0) {
        paramXmlSerializer.attribute(null, "mini_program_type", String.valueOf(this.f));
      }
      if (!TextUtils.isEmpty(this.B)) {
        paramXmlSerializer.attribute(null, "rl", this.B);
      }
      if (!TextUtils.isEmpty(this.C)) {
        paramXmlSerializer.attribute(null, "subordinate_product_id", this.C);
      }
      if (!TextUtils.isEmpty(this.D)) {
        paramXmlSerializer.attribute(null, "traceid", this.D);
      }
      if (!TextUtils.isEmpty(this.E)) {
        paramXmlSerializer.attribute(null, "via", this.E);
      }
      if (!TextUtils.isEmpty(this.F)) {
        paramXmlSerializer.attribute(null, "video_url", this.F);
      }
      if (!TextUtils.isEmpty(this.G)) {
        paramXmlSerializer.attribute(null, "appname", this.G);
      }
      if (!TextUtils.isEmpty(this.H)) {
        paramXmlSerializer.attribute(null, "customized_invoke_url", this.H);
      }
      if (!TextUtils.isEmpty(this.I)) {
        paramXmlSerializer.attribute(null, "pkg_name", this.I);
      }
      if (!TextUtils.isEmpty(this.J)) {
        paramXmlSerializer.attribute(null, "pkgurl", this.J);
      }
      if (!TextUtils.isEmpty(this.N)) {
        paramXmlSerializer.attribute(null, "corporate_image_name", this.N);
      }
      if (!TextUtils.isEmpty(this.O)) {
        paramXmlSerializer.attribute(null, "corporate_logo", this.O);
      }
      if (this.g != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.g));
      }
      if (this.h != 0) {
        paramXmlSerializer.attribute(null, "tab_id", String.valueOf(this.h));
      }
      if (!TextUtils.isEmpty(this.P)) {
        paramXmlSerializer.attribute(null, "negative_feedback_url", this.P);
      }
      if (!TextUtils.isEmpty(this.Q)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.Q);
      }
      if (!TextUtils.isEmpty(this.R)) {
        paramXmlSerializer.attribute(null, "sdk_exposure_monitor_url", this.R);
      }
      if (this.i != 0) {
        paramXmlSerializer.attribute(null, "media_duration", String.valueOf(this.i));
      }
      if (this.j != 0) {
        paramXmlSerializer.attribute(null, "video_file_size", String.valueOf(this.j));
      }
      if (this.k != 0) {
        paramXmlSerializer.attribute(null, "app_score_num", String.valueOf(this.k));
      }
      if (this.l != 0) {
        paramXmlSerializer.attribute(null, "download_num", String.valueOf(this.l));
      }
      if (!TextUtils.isEmpty(this.S)) {
        paramXmlSerializer.attribute(null, "universal_link", this.S);
      }
      if (!TextUtils.isEmpty(this.T)) {
        paramXmlSerializer.attribute(null, "sdk_data", this.T);
      }
      if (!TextUtils.isEmpty(this.U)) {
        paramXmlSerializer.attribute(null, "tencent_video_id", this.U);
      }
      if (!TextUtils.isEmpty(this.V)) {
        paramXmlSerializer.attribute(null, "view_id", this.V);
      }
      if (!TextUtils.isEmpty(this.W)) {
        paramXmlSerializer.attribute(null, "qgg_ext", this.W);
      }
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a()
  {
    return (this.v >= 1) && (this.v <= 100);
  }
  
  public boolean a(bcxj parambcxj)
  {
    if (parambcxj == null) {}
    for (;;)
    {
      return true;
      this.aa = parambcxj.a("cover");
      this.ab = parambcxj.a("src");
      String str1 = parambcxj.a("load");
      this.ac = parambcxj.a("vInfo");
      this.ad = parambcxj.a("tInfo");
      String str3 = parambcxj.a("preTime");
      if (str3 != null) {}
      try
      {
        this.q = Integer.valueOf(str3).intValue();
        str3 = parambcxj.a("preWidth");
        if (str3 == null) {}
      }
      catch (Exception localNumberFormatException3)
      {
        try
        {
          this.r = Integer.valueOf(str3).intValue();
          label104:
          str3 = parambcxj.a("preHeight");
          if (str3 != null) {}
          try
          {
            this.s = Integer.valueOf(str3).intValue();
            label127:
            str3 = parambcxj.a("fullTime");
            if (str3 != null) {}
            try
            {
              this.t = Integer.valueOf(str3).intValue();
              label150:
              this.ae = parambcxj.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.o = Integer.parseInt(str1);
                label176:
                str1 = parambcxj.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localNumberFormatException3)
              {
                try
                {
                  this.v = Integer.parseInt(str1);
                  label199:
                  this.ah = parambcxj.a("aID");
                  this.as = parambcxj.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(parambcxj.a("isJump2Web"));
                  str1 = parambcxj.a("preStartPosi");
                  if (!TextUtils.isEmpty(str1)) {}
                  try
                  {
                    this.p = Integer.valueOf(str1).intValue();
                    this.at = parambcxj.a("apurl");
                    this.au = parambcxj.a("rl");
                    this.av = parambcxj.a("disType");
                    str1 = parambcxj.a("feedId");
                    if (TextUtils.isEmpty(str1)) {}
                  }
                  catch (Exception localNumberFormatException3)
                  {
                    try
                    {
                      this.jdField_c_of_type_Long = Long.parseLong(str1);
                      str1 = parambcxj.a("feedType");
                      if (TextUtils.isEmpty(str1)) {}
                    }
                    catch (Exception localNumberFormatException3)
                    {
                      try
                      {
                        this.u = Integer.parseInt(str1);
                        if (this.jdField_a_of_type_Int >= 13)
                        {
                          str1 = parambcxj.a("action_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                      }
                      catch (Exception localNumberFormatException3)
                      {
                        try
                        {
                          this.jdField_c_of_type_Int = Integer.parseInt(str1);
                          str1 = parambcxj.a("dest_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                        catch (NumberFormatException localNumberFormatException3)
                        {
                          try
                          {
                            this.jdField_d_of_type_Int = Integer.parseInt(str1);
                            str1 = parambcxj.a("product_type");
                            if (TextUtils.isEmpty(str1)) {}
                          }
                          catch (NumberFormatException localNumberFormatException3)
                          {
                            try
                            {
                              this.e = Integer.parseInt(str1);
                              this.r = parambcxj.a("advertiser_id");
                              this.s = parambcxj.a("aid");
                              this.t = parambcxj.a("app_download_schema");
                              this.u = parambcxj.a("canvas_json");
                              this.v = parambcxj.a("customized_invoke_url");
                              this.w = parambcxj.a("effect_url");
                              this.x = parambcxj.a("landing_page");
                              this.y = parambcxj.a("landing_page_report_url");
                              this.z = parambcxj.a("noco_id");
                              this.A = parambcxj.a("product_id");
                              this.C = parambcxj.a("subordinate_product_id");
                              this.D = parambcxj.a("traceid");
                              this.E = parambcxj.a("via");
                              this.F = parambcxj.a("video_url");
                              this.G = parambcxj.a("appname");
                              this.H = parambcxj.a("customized_invoke_url");
                              this.I = parambcxj.a("pkg_name");
                              this.J = parambcxj.a("pkgurl");
                              this.B = parambcxj.a("rl");
                              this.q = parambcxj.a("apurl");
                              this.N = parambcxj.a("corporate_image_name");
                              this.O = parambcxj.a("corporate_logo");
                              if (this.jdField_a_of_type_Int >= 14)
                              {
                                str1 = parambcxj.a("mini_program_type");
                                if (TextUtils.isEmpty(str1)) {}
                              }
                            }
                            catch (NumberFormatException localNumberFormatException3)
                            {
                              try
                              {
                                for (;;)
                                {
                                  for (;;)
                                  {
                                    this.f = Integer.parseInt(str1);
                                    if ((parambcxj.a != null) && (parambcxj.a.a != null)) {
                                      break label922;
                                    }
                                    QLog.i("structmsg.StructMsgItemVideo", 2, "node's parent or parent's parent is null");
                                    return true;
                                    localException10 = localException10;
                                    try
                                    {
                                      this.q = ((int)Float.valueOf(str3).floatValue());
                                      if (!QLog.isColorLevel()) {
                                        break;
                                      }
                                      QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.q);
                                    }
                                    catch (Exception localException5) {}
                                  }
                                  break;
                                  localRuntimeException = localRuntimeException;
                                  this.o = 0;
                                  break label176;
                                  localException6 = localException6;
                                  try
                                  {
                                    this.p = ((int)Float.valueOf(localRuntimeException).floatValue());
                                    if (!QLog.isColorLevel()) {
                                      continue;
                                    }
                                    QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.p);
                                  }
                                  catch (Exception localException1) {}
                                  continue;
                                  localException2 = localException2;
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.d("structmsg.StructMsgItemVideo", 2, "error while feedIdStr to feedId Long!");
                                    continue;
                                    localException3 = localException3;
                                    if (QLog.isColorLevel())
                                    {
                                      QLog.d("structmsg.StructMsgItemVideo", 2, "error while parse feedTypeStr to feedType int!");
                                      continue;
                                      localNumberFormatException1 = localNumberFormatException1;
                                      this.jdField_c_of_type_Int = 0;
                                      continue;
                                      localNumberFormatException2 = localNumberFormatException2;
                                      this.jdField_d_of_type_Int = 0;
                                    }
                                  }
                                }
                                localNumberFormatException3 = localNumberFormatException3;
                                this.e = 0;
                              }
                              catch (NumberFormatException localNumberFormatException4)
                              {
                                for (;;)
                                {
                                  this.f = 0;
                                }
                                label922:
                                parambcxj = parambcxj.a.a;
                                String str2;
                                if (this.jdField_a_of_type_Int >= 15)
                                {
                                  str2 = parambcxj.a("tab_id");
                                  if (bgsp.a(str2)) {}
                                }
                                try
                                {
                                  this.g = Integer.parseInt(str2);
                                  str2 = parambcxj.a("is_hidden");
                                  if (bgsp.a(str2)) {}
                                }
                                catch (NumberFormatException localNumberFormatException9)
                                {
                                  try
                                  {
                                    this.h = Integer.parseInt(str2);
                                    if (this.jdField_a_of_type_Int >= 16)
                                    {
                                      this.P = parambcxj.a("negative_feedback_url");
                                      this.Q = parambcxj.a("sdk_exposure_monitor_url");
                                      this.R = parambcxj.a("sdk_click_monitor_url");
                                      str2 = parambcxj.a("media_duration");
                                      if (bgsp.a(str2)) {}
                                    }
                                  }
                                  catch (NumberFormatException localNumberFormatException9)
                                  {
                                    try
                                    {
                                      this.i = Integer.parseInt(str2);
                                      str2 = parambcxj.a("video_file_size");
                                      if (bgsp.a(str2)) {}
                                    }
                                    catch (NumberFormatException localNumberFormatException9)
                                    {
                                      try
                                      {
                                        this.j = Integer.parseInt(str2);
                                        str2 = parambcxj.a("app_score_num");
                                        if (bgsp.a(str2)) {}
                                      }
                                      catch (NumberFormatException localNumberFormatException9)
                                      {
                                        try
                                        {
                                          this.k = Integer.parseInt(str2);
                                          str2 = parambcxj.a("download_num");
                                          if (bgsp.a(str2)) {}
                                        }
                                        catch (NumberFormatException localNumberFormatException9)
                                        {
                                          try
                                          {
                                            for (;;)
                                            {
                                              this.l = Integer.parseInt(str2);
                                              this.S = parambcxj.a("universal_link");
                                              this.T = parambcxj.a("sdk_data");
                                              this.U = parambcxj.a("tencent_video_id");
                                              this.V = parambcxj.a("view_id");
                                              if (this.jdField_a_of_type_Int < 17) {
                                                break;
                                              }
                                              this.W = parambcxj.a("qgg_ext");
                                              return true;
                                              localNumberFormatException5 = localNumberFormatException5;
                                              this.g = 0;
                                              continue;
                                              localNumberFormatException6 = localNumberFormatException6;
                                              this.h = 0;
                                              continue;
                                              localNumberFormatException7 = localNumberFormatException7;
                                              this.i = 0;
                                              continue;
                                              localNumberFormatException8 = localNumberFormatException8;
                                              this.j = 0;
                                            }
                                            localNumberFormatException9 = localNumberFormatException9;
                                            this.k = 0;
                                          }
                                          catch (NumberFormatException localNumberFormatException10)
                                          {
                                            for (;;)
                                            {
                                              this.l = 0;
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
                catch (Exception localException4)
                {
                  break label199;
                }
              }
            }
            catch (Exception localException7)
            {
              break label150;
            }
          }
          catch (Exception localException8)
          {
            break label127;
          }
        }
        catch (Exception localException9)
        {
          break label104;
        }
      }
    }
  }
  
  protected View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject1 = paramContext.getResources();
    int i;
    int j;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      i = afur.a(12.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      j = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130845416);
        paramView.setTag(this);
        try
        {
          localObject2 = new bcvy(-16777216, j, j, i);
          if (TextUtils.isEmpty(this.aa))
          {
            paramView.setBackgroundDrawable((Drawable)localObject2);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            paramView.setOnClickListener(this.b);
            paramView.setOnClickListener(this.b);
            if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
            {
              paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
              paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            }
            return localObject1;
            paramView = new TitledImageView(paramContext);
            paramView.setId(2131368420);
            paramView.setContentDescription(((Resources)localObject1).getString(2131694050));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131718238));
            localObject1 = paramView;
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localDrawable = null;
          }
        }
      }
    }
    for (;;)
    {
      URLDrawable localURLDrawable;
      try
      {
        localURLDrawable = URLDrawable.getDrawable(this.aa, j, j, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new bdbf(this, i, j, j));
        }
        if ((bdsh.b(this.aa)) || (!bdzx.a(paramContext))) {
          break label402;
        }
        localURLDrawable.setAutoDownload(bool);
        if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1)) {
          break label379;
        }
        paramView.setBackgroundDrawable(localURLDrawable);
      }
      catch (Throwable paramContext)
      {
        paramView.setBackgroundDrawable(localDrawable);
      }
      break label113;
      label379:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundDrawable(localURLDrawable);
      break label113;
      i = 0;
      break;
      label402:
      bool = true;
    }
  }
  
  public boolean b()
  {
    return this.v == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdaz
 * JD-Core Version:    0.7.0.1
 */