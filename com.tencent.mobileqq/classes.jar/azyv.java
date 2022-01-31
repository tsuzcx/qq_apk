import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azyv
  extends azxl
{
  String S = "StructMsgItemLayoutNew2";
  String T = "";
  String U = "";
  String V = "";
  private URLDrawableDownListener.Adapter a;
  
  public azyv()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new azyw(this);
  }
  
  public static String a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject2 = "";
    if (paramString.equals("cover"))
    {
      if (TextUtils.isEmpty(paramAbsShareMsg.mContentCover)) {
        break label77;
      }
      localObject1 = paramAbsShareMsg.mContentCover;
    }
    label77:
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (paramString.equals("title"))
          {
            if (!TextUtils.isEmpty(paramAbsShareMsg.mContentTitle)) {
              return paramAbsShareMsg.mContentTitle;
            }
          }
          else if ((paramString.equals("summary")) && (!TextUtils.isEmpty(paramAbsShareMsg.mContentSummary))) {
            return paramAbsShareMsg.mContentSummary;
          }
          localObject1 = localObject2;
        } while (!(paramAbsShareMsg instanceof StructMsgForGeneralShare));
        paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
        localObject1 = localObject2;
      } while (paramAbsShareMsg.mStructMsgItemLists == null);
      localObject1 = localObject2;
    } while (paramAbsShareMsg.mStructMsgItemLists.isEmpty());
    Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
    paramAbsShareMsg = (AbsShareMsg)localObject2;
    do
    {
      localObject1 = paramAbsShareMsg;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (azus)localIterator.next();
    } while ((!(localObject1 instanceof azut)) || (((azut)localObject1).a == null) || (((azut)localObject1).a.isEmpty()));
    Object localObject1 = ((azut)localObject1).a.iterator();
    label191:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (azus)((Iterator)localObject1).next();
      if ((paramString.equals("cover")) && ((localObject2 instanceof azwv)))
      {
        paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((azus)localObject2);
        label231:
        if (TextUtils.isEmpty(paramAbsShareMsg)) {
          break label295;
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramAbsShareMsg))
      {
        return paramAbsShareMsg;
        if ((paramString.equals("title")) && ((localObject2 instanceof StructMsgItemTitle)))
        {
          paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((azus)localObject2);
          break label231;
        }
        if ((!paramString.equals("summary")) || (!(localObject2 instanceof azzm))) {
          break label301;
        }
        paramAbsShareMsg = StructMsgForGeneralShare.getSummary((azus)localObject2);
        break label231;
        label295:
        break label191;
      }
      break;
      label301:
      break label231;
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    int n = paramString.length();
    int k = 0;
    if ((i < n) && (k < paramInt))
    {
      int j = paramString.codePointAt(i);
      int m;
      if ((j > 65535) || (j == 20))
      {
        m = i;
        j = k;
        if (i + 1 < n)
        {
          str = paramString.substring(i, i + 2);
          if (k < paramInt - 1) {
            localStringBuilder.append(str);
          }
          m = i + 1;
          j = k + 1;
        }
      }
      for (;;)
      {
        i = m + 1;
        k = j;
        break;
        str = paramString.substring(i, i + 1);
        if (k < paramInt - 1) {
          localStringBuilder.append(str);
        }
        j = k + 1;
        m = i;
      }
    }
    if (k == paramInt)
    {
      if (i >= n) {
        break label188;
      }
      localStringBuilder.append(Html.fromHtml("&hellip;"));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      localStringBuilder.append(str);
    }
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
      if ((localObject instanceof MessageForStructing))
      {
        localObject = (AbsShareMsg)azvd.a(((MessageRecord)localObject).msgData);
        this.U = a((AbsShareMsg)localObject, "title");
        this.T = a((AbsShareMsg)localObject, "cover");
        this.V = a((AbsShareMsg)localObject, "summary");
      }
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject = new azyy(this);
    Resources localResources = paramContext.getResources();
    View localView;
    int i;
    label122:
    int j;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && (paramView.findViewById(2131363766) != null) && ((paramView.getTag() instanceof azyy)))
    {
      localObject = (azyy)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      a();
      boolean bool = paramBundle.getBoolean("isSend", true);
      paramBundle = (BubbleViewLayout)localView.findViewById(2131363766);
      i = 19;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 114) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 116)) {
        break label911;
      }
      paramBundle.a(false);
      i = 9;
      paramBundle.a = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 151) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID == 156) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgActionData))) {
        break label919;
      }
      j = 1;
      label177:
      if (!bool) {
        break label936;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(aepi.a(9.0F, localResources), 0, aepi.a(i, localResources), 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setPadding(aepi.a(9.0F, localResources), aepi.a(3.0F, localResources), aepi.a(i, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (j == 0) {
        break label925;
      }
      paramBundle.setMargins(aepi.a(18.0F, localResources), 0, 0, 0);
      ((RelativeLayout.LayoutParams)paramView.c.getLayoutParams()).addRule(9);
      paramBundle = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramBundle.addRule(9);
      paramBundle.setMargins(aepi.a(18.0F, localResources), 0, 0, 0);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(aepi.a(19.5F, localResources), 0, aepi.a(10.0F, localResources), 0);
      label339:
      paramBundle = localResources.getDrawable(2130849859);
      if (TextUtils.isEmpty(this.T)) {
        break label1192;
      }
    }
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.T), aepi.a(249.0F, localResources), aepi.a(139.0F, localResources), paramBundle, paramBundle, true);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1)) {
        break label1107;
      }
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(null);
      label454:
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        label463:
        label1107:
        if (QLog.isColorLevel()) {
          QLog.e(this.S, 2, "getView, error: " + localMalformedURLException.getMessage());
        }
        label516:
        label911:
        label919:
        label925:
        label936:
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      }
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
    {
      this.U += "  ";
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(Html.fromHtml(this.U));
      if ((this.V == null) || (TextUtils.isEmpty(this.V.trim())) || (this.V.trim().equals(""))) {
        break label1227;
      }
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(this.V);
    }
    for (;;)
    {
      if (j == 0) {
        break label1239;
      }
      i = (int)(BaseChatItemLayout.A * 0.8F) - aepi.a(19.5F, localResources) - aepi.a(10.0F, localResources) - aepi.a(13.0F, localResources);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(i);
      i /= aepi.a(14.0F, localResources);
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgActionData;
      paramBundle = (Bundle)localObject;
      if (((String)localObject).length() > i) {
        paramBundle = a((String)localObject, i);
      }
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(new bamz(paramBundle, 3, 15));
      paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramContext = new azyx(this, paramContext, new String(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgActionData), this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgUrl);
      paramView.c.setOnClickListener(paramContext);
      paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramContext);
      return localView;
      localView = LayoutInflater.from(paramContext).inflate(2131559495, null);
      ((azyy)localObject).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131364881));
      ((azyy)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377938));
      ((azyy)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)localView.findViewById(2131377276));
      ((azyy)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131363766));
      ((azyy)localObject).jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131362232));
      ((azyy)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131364541));
      ((azyy)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362231));
      ((azyy)localObject).c = ((RelativeLayout)localView.findViewById(2131363815));
      ((azyy)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363807));
      localView.setTag(localObject);
      paramView = (View)localObject;
      break;
      paramBundle.a(true);
      break label122;
      j = 0;
      break label177;
      paramBundle.setMargins(0, 0, 0, 0);
      break label339;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setPadding(aepi.a(i, localResources), 0, aepi.a(9.0F, localResources), 0);
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setPadding(aepi.a(i, localResources), aepi.a(3.0F, localResources), aepi.a(9.0F, localResources), 0);
      paramBundle = (ViewGroup.MarginLayoutParams)paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (j != 0)
      {
        paramBundle.setMargins(0, 0, aepi.a(18.0F, localResources), 0);
        ((RelativeLayout.LayoutParams)paramView.c.getLayoutParams()).addRule(11);
        paramBundle = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        paramBundle.addRule(11);
        paramBundle.setMargins(0, 0, aepi.a(18.0F, localResources), 0);
        paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(aepi.a(10.0F, localResources), 0, aepi.a(19.5F, localResources), 0);
        break label339;
      }
      paramBundle.setMargins(0, 0, 0, 0);
      break label339;
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break label454;
      label1192:
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBundle);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      break label463;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.U);
      break label516;
      label1227:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
    }
    label1239:
    paramView.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramView.c.setOnClickListener(null);
    paramView.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyv
 * JD-Core Version:    0.7.0.1
 */