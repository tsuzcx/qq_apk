package com.tencent.mobileqq.activity.activateFriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemAvatar;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.Calendar;

public class MemorialActivatePage
  extends ActivateBasePage
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private static String jdField_g_of_type_JavaLangString = "http://h5.qzone.qq.com/friend/day/%1$s/%2$s/friendDay?_wv=3&_proxy=1";
  private static String jdField_h_of_type_JavaLangString = "http://h5.qzone.qq.com/lover/memosAct?_wv=1027&_proxy=1";
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private SingleLineTextView jdField_a_of_type_ComTencentWidgetSingleLineTextView;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private SingleLineTextView jdField_b_of_type_ComTencentWidgetSingleLineTextView;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  
  public MemorialActivatePage(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramInt2;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Long /= 86400L;
    this.jdField_a_of_type_Long *= 86400L;
    paramString2 = Calendar.getInstance();
    paramString2.setTimeInMillis(this.jdField_a_of_type_Long * 1000L);
    paramString3 = Calendar.getInstance();
    long l1 = System.currentTimeMillis();
    paramString3.setTimeInMillis(l1);
    if (QLog.isColorLevel()) {
      QLog.d("MemorialActivatePage", 2, "time=" + paramString2.toString());
    }
    paramContext = String.format(paramContext.getString(2131438708), new Object[] { Integer.valueOf(Math.abs(paramString3.get(1) - paramString2.get(1))) });
    paramInt1 = new Long(Math.abs(l1 - this.jdField_a_of_type_Long * 1000L) / 86400000L).intValue();
    this.jdField_f_of_type_JavaLangString = (paramContext + paramString5);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    }
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramString1);
    if (paramString3 != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramString3);
      paramString1 = ContactUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
      this.j.setText(paramString1);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramQQAppInterface.getCurrentAccountUin());
      if (paramQQAppInterface == null) {
        break label573;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramQQAppInterface);
      label336:
      this.i.setText(ContactUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramContext);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(this.d);
      this.jdField_b_of_type_ComTencentWidgetSingleLineTextView.setText(this.c);
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.e);
      this.m.setText(paramInt1 + "");
      if (this.jdField_b_of_type_Int != 0) {
        break label604;
      }
      this.k.setText("分享给她");
    }
    for (;;)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(String.format("%d月%d日", new Object[] { Integer.valueOf(paramString2.get(2) + 1), Integer.valueOf(paramString2.get(5)) }));
      if (this.jdField_a_of_type_Int != 1) {
        break label617;
      }
      this.jdField_b_of_type_JavaLangString = String.format(jdField_g_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString });
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842125);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131493167));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString1, 1, true, (byte)0);
      break;
      label573:
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        break label336;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1, true, (byte)0);
      break label336;
      label604:
      this.k.setText("分享给他");
    }
    label617:
    this.jdField_b_of_type_JavaLangString = String.format(jdField_h_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842126);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#ff455e"));
    this.jdField_f_of_type_AndroidWidgetTextView.setAlpha(0.8F);
  }
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    Object localObject2 = this.jdField_b_of_type_JavaLangString;
    AbsShareMsg.Builder localBuilder = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(97);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_Int == 1) {}
    for (Object localObject1 = "[好友纪念日]";; localObject1 = "[恋爱纪念日]")
    {
      localObject1 = localBuilder.a((String)localObject1 + this.jdField_f_of_type_JavaLangString).a("web", (String)localObject2, (String)localObject2, (String)localObject2, (String)localObject2).a();
      localObject2 = StructMsgElementFactory.a(27);
      ((AbsStructMsgItem)localObject2).e = this.jdField_a_of_type_Int;
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(this.jdField_f_of_type_JavaLangString));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary(String.valueOf(this.jdField_a_of_type_Long)));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemAvatar(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ""));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemAvatar(1, this.jdField_a_of_type_JavaLangString, ""));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      ((AbsShareMsg)localObject1).mCompatibleText = "收到好友纪念日消息，请在最新版手机QQ上查看。";
      localIntent.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      localIntent.putExtra("forward_type", -3);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("emoInputType", 2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD9", "0X8007AD9", this.jdField_a_of_type_Int, 0, "", "", "", "");
      return localIntent;
    }
  }
  
  private void c()
  {
    ForwardBaseOption localForwardBaseOption = ForwardOptionBuilder.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)getContext());
    localForwardBaseOption.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", 0);
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("uinname", ContactUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString));
    localForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970164, this, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369354));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366837));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369360));
    this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369361));
    this.jdField_b_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369362));
    this.m = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369364));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369363));
    this.n = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369365));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369356));
    this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369358));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364582));
    this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369359));
    this.k = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366739));
    this.l = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362738));
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369336));
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(long paramLong)
  {
    CharSequence localCharSequence = TimeFormatterUtils.a(getContext(), 3, paramLong);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD6", "0X8007AD6", this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    super.b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366739: 
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_a_of_type_JavaLangString))
      {
        c();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD8", "0X8007AD8", this.jdField_a_of_type_Int, 0, "", "", "", "");
        return;
      }
      QQToast.a(getContext(), 1, "对方已不是你的好友，无法进行分享。", 1).a();
      return;
    }
    paramView = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_b_of_type_JavaLangString);
    paramView.putExtra("injectrecommend", true);
    paramView.setData(Uri.parse(this.jdField_b_of_type_JavaLangString));
    getContext().startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007AD7", "0X8007AD7", this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
    {
      if (!paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label34;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    label34:
    while (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.MemorialActivatePage
 * JD-Core Version:    0.7.0.1
 */