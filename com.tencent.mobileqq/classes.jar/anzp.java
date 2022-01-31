import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionInvalidPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import mqq.os.MqqHandler;

public class anzp
  extends aoad
  implements Handler.Callback, View.OnClickListener
{
  protected Button a;
  protected LinearLayout a;
  protected EmoticonPackage a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  protected int f;
  protected int g;
  
  public anzp(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, anyb paramanyb)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramanyb);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.f = (XPanelContainer.jdField_a_of_type_Int - (int)paramContext.getResources().getDimension(2131296829));
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (paramEmoticonPackage.mobileFeetype != 4) {
        break;
      }
      this.g = 1;
      return;
    }
    this.g = 2;
  }
  
  private LinearLayout a(anzq paramanzq)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-16777216);
    localLinearLayout.getBackground().setAlpha(178);
    localLinearLayout.setGravity(16);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f));
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    localTextView.setGravity(1);
    localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new Button(this.jdField_a_of_type_AndroidContentContext);
    ((Button)localObject).setId(2131364882);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839060));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.jdField_a_of_type_Float * 30.0F), 0, (int)(this.jdField_a_of_type_Float * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramanzq.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
    paramanzq.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    paramanzq.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject);
    return localLinearLayout;
  }
  
  private void b(View paramView, aoah paramaoah)
  {
    if ((paramView == null) || (paramaoah == null))
    {
      QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI contentView or info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "updateUI");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramView.setVisibility(0);
      if (!(paramaoah instanceof anyc)) {
        break label107;
      }
    }
    label107:
    for (paramaoah = (anyc)paramaoah;; paramaoah = null)
    {
      if (paramaoah == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView = (URLImageView)paramView.findViewById(2131365584);
      paramView.setImageDrawable(paramaoah.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
      paramView.setVisibility(0);
      return;
      super.a(paramView, paramaoah);
      return;
    }
  }
  
  public View a(anxe paramanxe, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (anzq)paramanxe;
    paramViewGroup = paramView;
    label104:
    int i;
    label258:
    int j;
    label305:
    int m;
    int n;
    if (paramView == null)
    {
      paramViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout localLinearLayout = a((anzq)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label377;
      }
      paramView = aoap.a().a(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        paramanxe = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 7, this.jdField_a_of_type_Int);
        if (!this.jdField_a_of_type_Boolean) {
          break label497;
        }
        a(11, paramanxe);
        paramViewGroup.addView(paramanxe, new FrameLayout.LayoutParams(-1, this.f));
        paramViewGroup.addView(localLinearLayout);
        ((anzq)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout = ((EmotionInvalidPanelLinearLayout)paramanxe);
        paramViewGroup.setTag(localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((anzq)localObject).jdField_a_of_type_AndroidWidgetButton;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((anzq)localObject).jdField_a_of_type_AndroidWidgetLinearLayout;
      paramView = ajyc.a(2131704105);
      paramanxe = ajyc.a(2131704107);
      if (this.g == 2) {
        paramanxe = ajyc.a(2131704108);
      }
      paramanxe = ajyc.a(2131704101) + paramanxe + "专享,\n开通" + paramanxe + ajyc.a(2131704104);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 6) {
        break label507;
      }
      paramanxe = ajyc.a(2131704103);
      paramView = ajyc.a(2131704098);
      ((anzq)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramanxe);
      ((anzq)localObject).jdField_a_of_type_AndroidWidgetButton.setText(paramView);
      ((anzq)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      paramanxe = ((anzq)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout;
      int i1 = paramanxe.getChildCount();
      j = 0;
      if (j >= i1) {
        break label663;
      }
      paramView = (LinearLayout)paramanxe.getChildAt(j);
      if (paramInt == 0) {
        break label563;
      }
      paramView.setVisibility(8);
      m = i;
      n = paramInt;
    }
    label377:
    label507:
    int i2;
    label497:
    int k;
    label563:
    do
    {
      j += 1;
      paramInt = n;
      i = m;
      break label305;
      paramanxe = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
      paramanxe = paramView;
      break;
      paramView = aoap.a().a(10);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from inflater");
        }
        paramanxe = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 4, this.jdField_a_of_type_Int);
        break;
      }
      paramanxe = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from cache");
      paramanxe = paramView;
      break;
      a(10, paramanxe);
      break label104;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 2)
      {
        paramanxe = ajyc.a(2131704100);
        paramView = ajyc.a(2131704102);
        break label258;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 3) {
        break label258;
      }
      paramanxe = ajyc.a(2131704099);
      paramView = ajyc.a(2131704106);
      break label258;
      i2 = paramView.getChildCount();
      k = 0;
      n = paramInt;
      m = i;
    } while (k >= i2);
    localObject = paramView.getChildAt(k);
    if (i > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      ((View)localObject).setVisibility(8);
      paramInt = 1;
    }
    for (;;)
    {
      k += 1;
      break;
      ((View)localObject).setVisibility(0);
      b((View)localObject, (aoah)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    label663:
    return paramViewGroup;
  }
  
  public anxe a()
  {
    return new anzq();
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "payBack");
    }
    if (18 == paramInt) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(100);
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramMessage != null) {
        paramMessage.obtainMessage(41).sendToTarget();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView.getId() == 2131364882)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
        break label28;
      }
      QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
    }
    label28:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
          break;
        }
        Object localObject = "mvip.gexinghua.android.sbp_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
        paramView = "!vip";
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
          paramView = "!svip";
        }
        paramView = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + paramView + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
        }
      } while (this.jdField_a_of_type_Boolean);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
    for (;;)
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzp
 * JD-Core Version:    0.7.0.1
 */