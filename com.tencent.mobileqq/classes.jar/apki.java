import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.image.RoundRectDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardPreviewMixedMsgController.1;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apki
  extends apkg
{
  private int a;
  protected LinearLayout a;
  protected QQAppInterface a;
  
  public apki(bafb parambafb, QQAppInterface paramQQAppInterface)
  {
    super(parambafb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      paramChatMessage = (MessageForMixedMsg)paramChatMessage;
      if (paramChatMessage.msgElemList != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewMixedMsgController", 2, " initMixMsgLayout size:" + paramChatMessage.msgElemList.size());
        }
        int i = bajq.a(4.0F);
        paramChatMessage = new ArrayList(paramChatMessage.msgElemList).iterator();
        while (paramChatMessage.hasNext())
        {
          Object localObject2 = (MessageRecord)paramChatMessage.next();
          Object localObject1;
          if ((localObject2 instanceof MessageForText))
          {
            localObject1 = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099994));
            ((AnimationTextView)localObject1).setSpannableFactory(axkd.a);
            if (!TextUtils.isEmpty(((MessageForText)localObject2).sb2)) {
              ((AnimationTextView)localObject1).setText(new axkd(((MessageForText)localObject2).sb2.toString(), 5, 20));
            }
            for (;;)
            {
              localObject2 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject2).gravity = 3;
              ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
              break;
              if (!TextUtils.isEmpty(((MessageForText)localObject2).sb)) {
                ((AnimationTextView)localObject1).setText(new axkd(((MessageForText)localObject2).sb.toString(), 5, 20));
              } else if (!TextUtils.isEmpty(((MessageForText)localObject2).msg)) {
                ((AnimationTextView)localObject1).setText(new axkd(((MessageForText)localObject2).msg, 5, 20));
              }
            }
          }
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            localObject2 = adkt.a(this.jdField_a_of_type_AndroidContentContext, (MessageForPic)localObject2);
            if (localObject2 != null)
            {
              if (((((URLDrawable)localObject2).getCurrDrawable() instanceof RoundRectDrawable)) && (a()))
              {
                RoundRectDrawable localRoundRectDrawable = (RoundRectDrawable)((URLDrawable)localObject2).getCurrDrawable();
                ((ImageView)localObject1).setImageDrawable(new amym(0, localRoundRectDrawable.getIntrinsicWidth(), localRoundRectDrawable.getIntrinsicHeight()));
                ((ImageView)localObject1).postDelayed(new ForwardPreviewMixedMsgController.1(this, (ImageView)localObject1, (URLDrawable)localObject2), 300L);
              }
              for (;;)
              {
                ((ImageView)localObject1).setAdjustViewBounds(true);
                localObject2 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject2).gravity = 3;
                ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
                this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
                break;
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
              }
            }
          }
          else if ((localObject2 instanceof MessageForReplyText))
          {
            localObject2 = (MessageForReplyText)localObject2;
            localObject1 = new AnimationTextView(this.jdField_a_of_type_AndroidContentContext);
            ((AnimationTextView)localObject1).setTextSize(17.0F);
            ((AnimationTextView)localObject1).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131099994));
            ((AnimationTextView)localObject1).setSpannableFactory(axkd.a);
            if (!TextUtils.isEmpty(((MessageForReplyText)localObject2).sb))
            {
              ((AnimationTextView)localObject1).setText(new axkd(((MessageForReplyText)localObject2).sb.toString(), 5, 20));
              ((AnimationTextView)localObject1).setVisibility(0);
            }
            for (;;)
            {
              localObject2 = new LinearLayout.LayoutParams(-2, -2);
              ((LinearLayout.LayoutParams)localObject2).gravity = 3;
              ((LinearLayout.LayoutParams)localObject2).setMargins(0, i, 0, i);
              this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
              break;
              ((AnimationTextView)localObject1).setVisibility(8);
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new apkj(this));
    }
  }
  
  private boolean a()
  {
    String str = Build.MODEL;
    if ((str.equals("vivo X20A")) || (str.equals("vivo X20")) || (str.equals("vivo X20Plus A")) || (str.equals("vivo X20Plus")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardPreviewMixedMsgController", 2, "isVivoBlackModel  ");
      }
      return true;
    }
    return false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight() >= bajq.a(this.jdField_a_of_type_Int + 1))
    {
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight(bajq.a(450.0F));
      this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.requestLayout();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardPreviewMixedMsgController", 2, " reset height ");
      }
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = ((int)((this.jdField_a_of_type_Bafb.getRootViewHeight() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165900)) / bajq.a));
    }
    return this.jdField_a_of_type_Int;
  }
  
  protected View a()
  {
    ScrollView localScrollView = new ScrollView(this.jdField_a_of_type_AndroidContentContext);
    localScrollView.setOverScrollMode(2);
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    int i = bajq.a(15.0F);
    int j = bajq.a(8.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(i, j, i, j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    localScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new ViewGroup.LayoutParams(-1, -2));
    return localScrollView;
  }
  
  public void a(String paramString, MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardPreviewMixedMsgController", 2, " bindData ");
    }
    if (paramString != null) {
      a(paramString);
    }
    if ((paramMessageForMixedMsg != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
      a(paramMessageForMixedMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apki
 * JD-Core Version:    0.7.0.1
 */