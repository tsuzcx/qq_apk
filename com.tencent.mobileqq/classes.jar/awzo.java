import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
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
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;

public class awzo
  extends awul
{
  public String S;
  public String T;
  public String U;
  public String V;
  public String W;
  public String X;
  public String Y;
  public String Z;
  protected View.OnClickListener a;
  public awzw a;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public String aa;
  String ab = "";
  String ac = "";
  String ai = "";
  String aj = "";
  String ak;
  String al;
  String am;
  String an;
  private View.OnClickListener b = new awzp(this);
  public boolean b;
  public long c;
  public boolean c;
  boolean d;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  
  public awzo()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new awzs(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new awzt(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.jdField_a_of_type_Int = 14;
  }
  
  public awzo(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, String paramString7, int paramInt7, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new awzs(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new awzt(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.S = paramString1;
    this.p = paramInt1;
    this.U = paramString2;
    this.V = paramString3;
    this.W = paramString4;
    this.k = paramInt2;
    this.j = paramInt3;
    this.l = paramInt4;
    this.m = paramInt5;
    this.n = paramInt6;
    this.X = paramString5;
    this.Y = paramString6;
    this.Z = paramString7;
    this.jdField_c_of_type_Long = paramLong;
    this.o = paramInt7;
    this.jdField_a_of_type_Int = 14;
  }
  
  public awzo(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new awzs(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new awzt(this);
    this.jdField_a_of_type_JavaLangString = "video";
    this.S = paramString1;
    this.T = paramString2;
    if (paramBoolean) {}
    for (;;)
    {
      this.i = i1;
      this.jdField_a_of_type_Int = 14;
      return;
      i1 = 0;
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
        rtr.a(localIntent, b());
        paramContext.startActivity(localIntent);
      } while (TextUtils.isEmpty(b()));
      paramContext = awup.a(b());
    } while (TextUtils.isEmpty(paramContext));
    awqx.b(null, "CliOper", "", "", "0X8005F58", "0X8005F58", 0, 0, "", "", paramContext, "");
  }
  
  private void a(Context paramContext, View paramView)
  {
    if (this.i == 1)
    {
      if ((paramView instanceof AnyScaleTypeImageView)) {
        ((AnyScaleTypeImageView)paramView).setImageResource(2130839111);
      }
      if (this.jdField_a_of_type_Awzw == null) {
        this.jdField_a_of_type_Awzw = new awzw(this);
      }
      ThreadManager.post(new StructMsgItemVideo.3(this, paramContext, paramView), 8, null, true);
      return;
    }
    a(paramContext, this.T);
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
      paramContext = awup.a(b());
      if (!TextUtils.isEmpty(paramContext)) {
        awqx.b(null, "CliOper", "", "", "0X8005F57", "0X8005F57", 0, 0, "", "", paramContext, "");
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
      this.aa = localBundle.getString("public_account_video_title");
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
      this.X = localBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
      if (localBundle.getString("VIDEO_PUB_ACCOUNT_NAME") == null) {
        break label282;
      }
    }
    Object localObject1;
    label262:
    label282:
    for (this.Y = localBundle.getString("VIDEO_PUB_ACCOUNT_NAME");; this.Y = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName))
    {
      this.ab = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceIcon;
      this.ac = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceName;
      this.ai = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceUrl;
      this.aj = ((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).mSourceThirdName;
      localObject1 = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label302;
      }
      if (paramView.getTag(2131310781) != null)
      {
        paramContext = paramView.getTag(2131310781);
        if ((paramContext instanceof awzv))
        {
          paramContext = (awzv)paramContext;
          if (QLog.isColorLevel()) {
            QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): 复用Holder!!");
          }
        }
      }
      return null;
      this.X = String.valueOf(((StructMsgForGeneralShare)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg).source_puin);
      break;
    }
    label302:
    paramView = new RelativeLayout(paramContext);
    paramBundle = new PAVideoView(paramContext);
    paramBundle.setId(2131310781);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle.setContentDescription(((Resources)localObject1).getText(2131653917));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    int i1;
    Object localObject3;
    label547:
    Object localObject4;
    label628:
    int i2;
    int i3;
    if (bool1)
    {
      paramBundle.setRadius(15.0F);
      paramBundle.b(true);
      paramBundle.d(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        paramBundle.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      }
      if (this.l >= this.m)
      {
        paramBundle.f = PAVideoView.e;
        paramBundle.jdField_c_of_type_Boolean = true;
        paramBundle.i = true;
        paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(paramContext);
        ((ImageView)localObject2).setImageResource(2130842556);
        ((ImageView)localObject2).setVisibility(8);
        i1 = aciy.a(62.0F, (Resources)localObject1);
        if (bool1) {
          i1 = aciy.a(50.0F, (Resources)localObject1);
        }
        localObject3 = new RelativeLayout.LayoutParams(i1, i1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(13);
        if (bool1)
        {
          i1 = aciy.a(10.0F, (Resources)localObject1) / 2;
          if (!paramBundle.jdField_d_of_type_Boolean) {
            break label1351;
          }
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = i1;
        }
        paramView.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new LinearLayout(paramContext);
        ((LinearLayout)localObject3).setHorizontalGravity(0);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131310781);
        ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131310781);
        ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131310781);
        if (!bool1) {
          break label1361;
        }
        i1 = aciy.a(7.0F, (Resources)localObject1);
        if (!bool1) {
          break label1429;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (!this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend())) {
          break label1374;
        }
        i2 = aciy.a(10.0F, (Resources)localObject1) + i1;
        i3 = i1;
      }
    }
    for (;;)
    {
      label680:
      ((LinearLayout)localObject3).setPadding(i3, i1, i2, i1);
      paramView.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(paramContext);
      ((TextView)localObject4).setId(2131310780);
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
        ((LinearLayout.LayoutParams)localObject5).rightMargin = aciy.a(7.0F, (Resources)localObject1);
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
        localObject5 = new awzv();
        ((awzv)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView = paramBundle;
        ((awzv)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
        ((awzv)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        ((awzv)localObject5).b = ((TextView)localObject1);
        ((awzv)localObject5).jdField_a_of_type_AndroidViewView = ((View)localObject3);
        paramView.setTag(2131310781, localObject5);
        paramView.setTag(this);
        ((awzv)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a(this, (awzv)localObject5);
        boolean bool2 = awug.a().a(paramContext, 3, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        if (QLog.isColorLevel()) {
          QLog.d("structmsg.StructMsgItemVideo", 2, "createView(): convertView=" + paramView + ", args = " + localBundle.toString() + "\n, hasHeadIcon = " + bool1 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uniseq + "\n, autoPlay = " + bool2 + ", vid = " + this.U);
        }
        if ((bool2) && (this.p != 4)) {
          break label1418;
        }
        ((awzv)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.d();
      }
      for (;;)
      {
        if (this.k > 0) {
          ((awzv)localObject5).b.setText(ShortVideoUtils.a(this.k * 1000));
        }
        if (!TextUtils.isEmpty(this.ak)) {
          paramView.setTag(2131310787, this.ak);
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
        localObject3 = ShortVideoUtils.a(this.l, this.m);
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
          if (this.l >= this.m) {
            break label1270;
          }
          paramBundle.f = PAVideoView.jdField_d_of_type_Int;
          break;
          paramBundle.setRadius(5.0F);
        }
        label1270:
        if (this.l > this.m)
        {
          paramBundle.f = PAVideoView.jdField_c_of_type_Int;
          break;
        }
        if ((this.l == this.m) && (this.l != 0) && (this.m != 0))
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
        ((RelativeLayout.LayoutParams)localObject3).leftMargin = i1;
        break label547;
        label1361:
        i1 = aciy.a(12.0F, (Resources)localObject1);
        break label628;
        label1374:
        i3 = aciy.a(10.0F, (Resources)localObject1) + i1;
        i2 = i1;
        break label680;
        ((TextView)localObject4).setTextSize(1, 19.0F);
        break label753;
        label1406:
        ((TextView)localObject1).setTextSize(1, 14.0F);
        break label823;
        label1418:
        ((awzv)localObject5).jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.f();
      }
      label1429:
      i2 = i1;
      i3 = i1;
    }
  }
  
  public String a()
  {
    return "video";
  }
  
  protected void a(Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, long paramLong)
  {
    if ((paramContext == null) || (paramStructMsgForGeneralShare == null)) {}
    label134:
    label672:
    label718:
    label742:
    do
    {
      return;
      Bundle localBundle;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramStructMsgForGeneralShare.currentAccountUin);
        if ((qji.a(paramContext)) || ((localQQAppInterface != null) && (localQQAppInterface.c())))
        {
          bbmy.a(paramContext, 2131630481, 1).b(paramContext.getResources().getDimensionPixelSize(2131167766));
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
          str = null;
        }
        localBundle = new Bundle();
        localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", this.X);
        if (this.p <= 1) {
          break label718;
        }
      }
      localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.aj);
      localBundle.putString("VIDEO_H5_URL", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mCreateTime)) && (paramStructMsgForGeneralShare.mCreateTime.indexOf(" ") != -1)) {}
      for (String str = paramStructMsgForGeneralShare.mCreateTime.substring(0, paramStructMsgForGeneralShare.mCreateTime.indexOf(" "));; str = paramStructMsgForGeneralShare.mCreateTime)
      {
        localBundle.putString("VIDEO_CREATE_TIME", str);
        localBundle.putString("VIDEO_TIME", String.valueOf(this.n));
        localBundle.putString("VIDEO_WIDTH", String.valueOf(this.l));
        localBundle.putString("VIDEO_HEIGHT", String.valueOf(this.m));
        localBundle.putString("VIDEO_VID", this.V);
        localBundle.putString("VIDEO_COVER", this.S);
        localBundle.putLong("VIDEO_PLAY_POSITION", paramLong);
        localBundle.putString("VIDEO_ARTICLE_ID", this.Z);
        localBundle.putString("VIDEO_TITLE", this.aa);
        boolean bool1 = true;
        if ((this.p == 2) || (this.p == 3)) {
          bool1 = false;
        }
        localBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool1);
        localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", this.p);
        if (b())
        {
          localBundle.putInt("VIDEO_FEED_TYPE", this.o);
          localBundle.putLong("VIDEO_FEED_ID", this.jdField_c_of_type_Long);
        }
        if (!bool1)
        {
          localBundle.putString("VIDEO_THIRD_ICON", this.ab);
          localBundle.putString("VIDEO_THIRD_NAME", this.ac);
          localBundle.putString("VIDEO_THIRD_ACTION", this.ai);
          if (this.p == 2)
          {
            ocm.a();
            localBundle.putString("VIDEO_THIRD_URL", ocm.a(this.V));
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
          awqx.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin, "0X8006830", "0X8006830", 0, 0, this.U, "" + this.p, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.msgId, "");
        }
        localBundle.putByteArray("STRUCT_MSG_BYTES", paramStructMsgForGeneralShare.getBytes());
        localBundle.putInt("VIDEO_AIO_UIN_TYPE", this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.uinType);
        localBundle.putBoolean("VIDEO_FROM_AIO", true);
        localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("PERFORMANCE_REPORT_VIDEO_FEEDS_JUMP_FROM", 1);
        localBundle.putInt("VIDEO_FROM_TYPE", 0);
        bool1 = false;
        try
        {
          boolean bool2 = odw.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          bool1 = bool2;
        }
        catch (Exception paramStructMsgForGeneralShare)
        {
          break label672;
        }
        if (!bool1) {
          break label742;
        }
        paramStructMsgForGeneralShare = new Intent();
        paramStructMsgForGeneralShare.putExtras(localBundle);
        MultiVideoFragment.a(paramContext, paramStructMsgForGeneralShare);
        if (!(paramContext instanceof Activity)) {
          break;
        }
        ((Activity)paramContext).overridePendingTransition(2130772036, 2130772038);
        return;
        localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", this.Y);
        break label134;
      }
      paramStructMsgForGeneralShare = new Intent(paramContext, VideoFeedsPlayActivity.class);
      paramStructMsgForGeneralShare.addFlags(536870912);
      paramStructMsgForGeneralShare.putExtras(localBundle);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).startActivityForResult(paramStructMsgForGeneralShare, 13005);
    ((Activity)paramContext).overridePendingTransition(2130772036, 2130772038);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.S = paramObjectInput.readUTF();
    this.T = paramObjectInput.readUTF();
    String str = paramObjectInput.readUTF();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.i = Integer.parseInt(str);
      if (this.jdField_a_of_type_Int >= 7)
      {
        this.U = paramObjectInput.readUTF();
        this.V = paramObjectInput.readUTF();
        this.k = paramObjectInput.readInt();
        this.l = paramObjectInput.readInt();
        this.m = paramObjectInput.readInt();
        this.n = paramObjectInput.readInt();
        this.W = paramObjectInput.readUTF();
        this.p = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 8) {
        this.Z = paramObjectInput.readUTF();
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        this.ak = paramObjectInput.readUTF();
        this.jdField_d_of_type_Boolean = "1".equals(paramObjectInput.readUTF());
      }
      if (this.jdField_a_of_type_Int >= 10) {
        this.j = paramObjectInput.readInt();
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        this.al = paramObjectInput.readUTF();
        this.am = paramObjectInput.readUTF();
        this.an = paramObjectInput.readUTF();
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        this.o = paramObjectInput.readInt();
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
      if (QLog.isColorLevel())
      {
        paramObjectInput = new StringBuilder();
        paramObjectInput.append("readExternal[:").append("\n");
        paramObjectInput.append("mVersion:").append(this.jdField_a_of_type_Int).append("\n");
        paramObjectInput.append("imgUrl:").append(this.S).append("\n");
        paramObjectInput.append("videoUrl:").append(this.T).append("\n");
        paramObjectInput.append("vInfo:").append(this.U).append("\n");
        paramObjectInput.append("tInfo:").append(this.V).append("\n");
        paramObjectInput.append("previewVideoTime:").append(this.k).append("\n");
        paramObjectInput.append("previewVideoWidth:").append(this.l).append("\n");
        paramObjectInput.append("previewVideoHeight:").append(this.m).append("\n");
        paramObjectInput.append("type:").append(this.p).append("\n");
        paramObjectInput.append("articleID").append(this.Z).append("\n");
        paramObjectInput.append("jumpUrl:").append(this.ak).append("\n");
        paramObjectInput.append("jump2Web:").append(this.jdField_d_of_type_Boolean).append("\n");
        paramObjectInput.append("previewStartPosi:").append(this.j).append("\n");
        if ((this.jdField_a_of_type_Int >= 12) && (b()))
        {
          paramObjectInput.append("feedId:").append(this.jdField_c_of_type_Long).append("\n");
          paramObjectInput.append("feedType:").append(this.o).append("\n");
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
        this.i = 0;
      }
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.S != null)
    {
      str = this.S;
      paramObjectOutput.writeUTF(str);
      if (this.T == null) {
        break label827;
      }
      str = this.T;
      label36:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeUTF(this.i + "");
      if (this.jdField_a_of_type_Int >= 7)
      {
        if (this.U == null) {
          break label833;
        }
        str = this.U;
        label92:
        paramObjectOutput.writeUTF(str);
        if (this.V == null) {
          break label839;
        }
        str = this.V;
        label111:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.k);
        paramObjectOutput.writeInt(this.l);
        paramObjectOutput.writeInt(this.m);
        paramObjectOutput.writeInt(this.n);
        if (this.W == null) {
          break label845;
        }
        str = this.W;
        label170:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.p);
      }
      if (this.jdField_a_of_type_Int >= 8)
      {
        if (this.Z == null) {
          break label851;
        }
        str = this.Z;
        label208:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 9)
      {
        if (this.ak == null) {
          break label857;
        }
        str = this.ak;
        label236:
        paramObjectOutput.writeUTF(str);
        if (!this.jdField_d_of_type_Boolean) {
          break label863;
        }
        str = "1";
        label254:
        paramObjectOutput.writeUTF(str);
      }
      if (this.jdField_a_of_type_Int >= 10) {
        paramObjectOutput.writeInt(this.j);
      }
      if (this.jdField_a_of_type_Int >= 11)
      {
        if (this.al == null) {
          break label870;
        }
        str = this.al;
        label301:
        paramObjectOutput.writeUTF(str);
        if (this.am == null) {
          break label876;
        }
        str = this.am;
        label320:
        paramObjectOutput.writeUTF(str);
        if (this.an == null) {
          break label882;
        }
        str = this.an;
        label339:
        paramObjectOutput.writeUTF(str);
      }
      if ((this.jdField_a_of_type_Int >= 12) && (b()))
      {
        paramObjectOutput.writeInt(this.o);
        paramObjectOutput.writeLong(this.jdField_c_of_type_Long);
      }
      if (this.jdField_a_of_type_Int >= 13)
      {
        if (this.q == null) {
          break label888;
        }
        str = this.q;
        label403:
        paramObjectOutput.writeUTF(str);
        if (this.B == null) {
          break label894;
        }
        str = this.B;
        label422:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_c_of_type_Int);
        if (this.r != null) {
          break label900;
        }
        str = "0";
        label450:
        paramObjectOutput.writeUTF(str);
        if (this.s != null) {
          break label908;
        }
        str = "0";
        label468:
        paramObjectOutput.writeUTF(str);
        if (this.t != null) {
          break label916;
        }
        str = "";
        label485:
        paramObjectOutput.writeUTF(str);
        if (this.u != null) {
          break label924;
        }
        str = "";
        label502:
        paramObjectOutput.writeUTF(str);
        if (this.v != null) {
          break label932;
        }
        str = "";
        label519:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.jdField_d_of_type_Int);
        if (this.w != null) {
          break label940;
        }
        str = "";
        label546:
        paramObjectOutput.writeUTF(str);
        if (this.x != null) {
          break label948;
        }
        str = "";
        label563:
        paramObjectOutput.writeUTF(str);
        if (this.y != null) {
          break label956;
        }
        str = "";
        label580:
        paramObjectOutput.writeUTF(str);
        if (this.z != null) {
          break label964;
        }
        str = "";
        label597:
        paramObjectOutput.writeUTF(str);
        if (this.A != null) {
          break label972;
        }
        str = "";
        label614:
        paramObjectOutput.writeUTF(str);
        paramObjectOutput.writeInt(this.e);
        if (this.C != null) {
          break label980;
        }
        str = "";
        label641:
        paramObjectOutput.writeUTF(str);
        if (this.D != null) {
          break label988;
        }
        str = "";
        label658:
        paramObjectOutput.writeUTF(str);
        if (this.E != null) {
          break label996;
        }
        str = "";
        label675:
        paramObjectOutput.writeUTF(str);
        if (this.F != null) {
          break label1004;
        }
        str = "";
        label692:
        paramObjectOutput.writeUTF(str);
        if (this.G != null) {
          break label1012;
        }
        str = "";
        label709:
        paramObjectOutput.writeUTF(str);
        if (this.H != null) {
          break label1020;
        }
        str = "";
        label726:
        paramObjectOutput.writeUTF(str);
        if (this.I != null) {
          break label1028;
        }
        str = "";
        label743:
        paramObjectOutput.writeUTF(str);
        if (this.J != null) {
          break label1036;
        }
        str = "";
        label760:
        paramObjectOutput.writeUTF(str);
        if (this.N != null) {
          break label1044;
        }
        str = "";
        label777:
        paramObjectOutput.writeUTF(str);
        if (this.O != null) {
          break label1052;
        }
      }
    }
    label900:
    label908:
    label916:
    label1052:
    for (String str = "";; str = this.O)
    {
      paramObjectOutput.writeUTF(str);
      if (this.jdField_a_of_type_Int >= 14) {
        paramObjectOutput.writeInt(this.f);
      }
      return;
      str = "";
      break;
      label827:
      str = "";
      break label36;
      label833:
      str = "";
      break label92;
      label839:
      str = "";
      break label111;
      label845:
      str = "";
      break label170;
      label851:
      str = "";
      break label208;
      label857:
      str = "";
      break label236;
      label863:
      str = "0";
      break label254;
      label870:
      str = "";
      break label301;
      label876:
      str = "";
      break label320;
      label882:
      str = "";
      break label339;
      label888:
      str = "";
      break label403;
      label894:
      str = "";
      break label422;
      str = this.r;
      break label450;
      str = this.s;
      break label468;
      str = this.t;
      break label485;
      label924:
      str = this.u;
      break label502;
      label932:
      str = this.v;
      break label519;
      label940:
      str = this.w;
      break label546;
      label948:
      str = this.x;
      break label563;
      label956:
      str = this.y;
      break label580;
      label964:
      str = this.z;
      break label597;
      label972:
      str = this.A;
      break label614;
      label980:
      str = this.C;
      break label641;
      label988:
      str = this.D;
      break label658;
      label996:
      str = this.E;
      break label675;
      label1004:
      str = this.F;
      break label692;
      label1012:
      str = this.G;
      break label709;
      label1020:
      str = this.H;
      break label726;
      str = this.I;
      break label743;
      str = this.J;
      break label760;
      str = this.N;
      break label777;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "video");
    if (!TextUtils.isEmpty(this.S)) {
      paramXmlSerializer.attribute(null, "cover", this.S);
    }
    if (!TextUtils.isEmpty(this.T)) {
      paramXmlSerializer.attribute(null, "src", this.T);
    }
    if (!TextUtils.isEmpty(this.U)) {
      paramXmlSerializer.attribute(null, "vInfo", this.U);
    }
    if (!TextUtils.isEmpty(this.V)) {
      paramXmlSerializer.attribute(null, "tInfo", this.V);
    }
    paramXmlSerializer.attribute(null, "preStartPosi", String.valueOf(this.j));
    paramXmlSerializer.attribute(null, "preTime", String.valueOf(this.k));
    paramXmlSerializer.attribute(null, "preWidth", String.valueOf(this.l));
    paramXmlSerializer.attribute(null, "preHeight", String.valueOf(this.m));
    paramXmlSerializer.attribute(null, "fullTime", String.valueOf(this.n));
    if (!TextUtils.isEmpty(this.W)) {
      paramXmlSerializer.attribute(null, "summary", this.W);
    }
    paramXmlSerializer.attribute(null, "busiType", String.valueOf(this.p));
    if (!TextUtils.isEmpty(this.Z)) {
      paramXmlSerializer.attribute(null, "aID", this.Z);
    }
    if (this.i == 1) {
      paramXmlSerializer.attribute(null, "load", this.i + "");
    }
    if (!TextUtils.isEmpty(this.ak)) {
      paramXmlSerializer.attribute(null, "jumpUrl", this.ak);
    }
    if (this.jdField_d_of_type_Boolean) {}
    for (String str = "1";; str = "0")
    {
      paramXmlSerializer.attribute(null, "isJump2Web", str);
      if (!TextUtils.isEmpty(this.al)) {
        paramXmlSerializer.attribute(null, "apurl", this.al);
      }
      if (!TextUtils.isEmpty(this.am)) {
        paramXmlSerializer.attribute(null, "rl", this.am);
      }
      if (!TextUtils.isEmpty(this.an)) {
        paramXmlSerializer.attribute(null, "disType", this.an);
      }
      if (this.jdField_c_of_type_Long != 0L) {
        paramXmlSerializer.attribute(null, "feedId", String.valueOf(this.jdField_c_of_type_Long));
      }
      if (this.o != 0) {
        paramXmlSerializer.attribute(null, "feedType", String.valueOf(this.o));
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
      paramXmlSerializer.endTag(null, "video");
      return;
    }
  }
  
  public boolean a()
  {
    return (this.p >= 1) && (this.p <= 100);
  }
  
  public boolean a(awwc paramawwc)
  {
    if (paramawwc == null) {}
    for (;;)
    {
      return true;
      this.S = paramawwc.a("cover");
      this.T = paramawwc.a("src");
      String str1 = paramawwc.a("load");
      this.U = paramawwc.a("vInfo");
      this.V = paramawwc.a("tInfo");
      String str2 = paramawwc.a("preTime");
      if (str2 != null) {}
      try
      {
        this.k = Integer.valueOf(str2).intValue();
        label81:
        str2 = paramawwc.a("preWidth");
        if (str2 == null) {}
      }
      catch (Exception localNumberFormatException2)
      {
        try
        {
          this.l = Integer.valueOf(str2).intValue();
          label104:
          str2 = paramawwc.a("preHeight");
          if (str2 != null) {}
          try
          {
            this.m = Integer.valueOf(str2).intValue();
            label127:
            str2 = paramawwc.a("fullTime");
            if (str2 != null) {}
            try
            {
              this.n = Integer.valueOf(str2).intValue();
              label150:
              this.W = paramawwc.a("summary");
              if (!TextUtils.isEmpty(str1)) {}
              try
              {
                this.i = Integer.parseInt(str1);
                label176:
                str1 = paramawwc.a("busiType");
                if (TextUtils.isEmpty(str1)) {}
              }
              catch (RuntimeException localNumberFormatException2)
              {
                try
                {
                  this.p = Integer.parseInt(str1);
                  label199:
                  this.Z = paramawwc.a("aID");
                  this.ak = paramawwc.a("jumpUrl");
                  this.jdField_d_of_type_Boolean = "1".equals(paramawwc.a("isJump2Web"));
                  str1 = paramawwc.a("preStartPosi");
                  if (!TextUtils.isEmpty(str1)) {}
                  try
                  {
                    this.j = Integer.valueOf(str1).intValue();
                    this.al = paramawwc.a("apurl");
                    this.am = paramawwc.a("rl");
                    this.an = paramawwc.a("disType");
                    str1 = paramawwc.a("feedId");
                    if (TextUtils.isEmpty(str1)) {}
                  }
                  catch (Exception localNumberFormatException2)
                  {
                    try
                    {
                      this.jdField_c_of_type_Long = Long.parseLong(str1);
                      str1 = paramawwc.a("feedType");
                      if (TextUtils.isEmpty(str1)) {}
                    }
                    catch (Exception localNumberFormatException2)
                    {
                      try
                      {
                        this.o = Integer.parseInt(str1);
                        if (this.jdField_a_of_type_Int >= 13)
                        {
                          str1 = paramawwc.a("action_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                      }
                      catch (Exception localNumberFormatException2)
                      {
                        try
                        {
                          this.jdField_c_of_type_Int = Integer.parseInt(str1);
                          str1 = paramawwc.a("dest_type");
                          if (TextUtils.isEmpty(str1)) {}
                        }
                        catch (NumberFormatException localNumberFormatException2)
                        {
                          try
                          {
                            this.jdField_d_of_type_Int = Integer.parseInt(str1);
                            str1 = paramawwc.a("product_type");
                            if (TextUtils.isEmpty(str1)) {}
                          }
                          catch (NumberFormatException localNumberFormatException2)
                          {
                            try
                            {
                              for (;;)
                              {
                                for (;;)
                                {
                                  this.e = Integer.parseInt(str1);
                                  this.r = paramawwc.a("advertiser_id");
                                  this.s = paramawwc.a("aid");
                                  this.t = paramawwc.a("app_download_schema");
                                  this.u = paramawwc.a("canvas_json");
                                  this.v = paramawwc.a("customized_invoke_url");
                                  this.w = paramawwc.a("effect_url");
                                  this.x = paramawwc.a("landing_page");
                                  this.y = paramawwc.a("landing_page_report_url");
                                  this.z = paramawwc.a("noco_id");
                                  this.A = paramawwc.a("product_id");
                                  this.C = paramawwc.a("subordinate_product_id");
                                  this.D = paramawwc.a("traceid");
                                  this.E = paramawwc.a("via");
                                  this.F = paramawwc.a("video_url");
                                  this.G = paramawwc.a("appname");
                                  this.H = paramawwc.a("customized_invoke_url");
                                  this.I = paramawwc.a("pkg_name");
                                  this.J = paramawwc.a("pkgurl");
                                  this.B = paramawwc.a("rl");
                                  this.q = paramawwc.a("apurl");
                                  this.N = paramawwc.a("corporate_image_name");
                                  this.O = paramawwc.a("corporate_logo");
                                  if (this.jdField_a_of_type_Int < 14) {
                                    break;
                                  }
                                  paramawwc = paramawwc.a("mini_program_type");
                                  if (TextUtils.isEmpty(paramawwc)) {
                                    break;
                                  }
                                  try
                                  {
                                    this.f = Integer.parseInt(paramawwc);
                                    return true;
                                  }
                                  catch (NumberFormatException paramawwc)
                                  {
                                    this.f = 0;
                                    return true;
                                  }
                                  localException10 = localException10;
                                  try
                                  {
                                    this.k = ((int)Float.valueOf(str2).floatValue());
                                    if (!QLog.isColorLevel()) {
                                      break label81;
                                    }
                                    QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewVideoTimeStr: previewVideoTime = " + this.k);
                                  }
                                  catch (Exception localException5) {}
                                }
                                break label81;
                                localRuntimeException = localRuntimeException;
                                this.i = 0;
                                break label176;
                                localException6 = localException6;
                                try
                                {
                                  this.j = ((int)Float.valueOf(localRuntimeException).floatValue());
                                  if (!QLog.isColorLevel()) {
                                    continue;
                                  }
                                  QLog.d("structmsg.StructMsgItemVideo", 2, "fromXml parse previewStartPosiStr: previewStartPosi = " + this.j);
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
                                  }
                                }
                              }
                              localNumberFormatException2 = localNumberFormatException2;
                              this.jdField_d_of_type_Int = 0;
                            }
                            catch (NumberFormatException localNumberFormatException3)
                            {
                              for (;;)
                              {
                                this.e = 0;
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
    int i1;
    int i2;
    label113:
    Drawable localDrawable;
    if (paramBundle.getBoolean("has_cnr"))
    {
      i1 = aciy.a(12.0F, (Resources)localObject1);
      ((Resources)localObject1).getDisplayMetrics();
      i2 = paramBundle.getInt("v_height");
      Object localObject2;
      if ((paramView != null) && ((paramView instanceof TitledImageView)))
      {
        localObject2 = (TitledImageView)paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      for (;;)
      {
        paramView.setImageResource(2130844498);
        paramView.setTag(this);
        try
        {
          localObject2 = new awur(-16777216, i2, i2, i1);
          if (TextUtils.isEmpty(this.S))
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
            paramView.setId(2131302327);
            paramView.setContentDescription(((Resources)localObject1).getString(2131629081));
            paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramView.setContentDescription(((Resources)localObject1).getText(2131653917));
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
        localURLDrawable = URLDrawable.getDrawable(this.S, i2, i2, localDrawable, localDrawable);
        if (paramBundle.getBoolean("has_cnr")) {
          localURLDrawable.setDecodeHandler(new awzu(this, i1, i2, i2));
        }
        if ((axoa.b(this.S)) || (!axwd.a(paramContext))) {
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
      i1 = 0;
      break;
      label402:
      bool = true;
    }
  }
  
  public boolean b()
  {
    return this.p == 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awzo
 * JD-Core Version:    0.7.0.1
 */