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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import mqq.os.MqqHandler;

public class asov
  extends aspm
  implements Handler.Callback, View.OnClickListener
{
  protected Button a;
  protected LinearLayout a;
  protected EmoticonPackage a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  protected int f;
  protected int g;
  
  public asov(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, asmr paramasmr)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramasmr);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.f = (XPanelContainer.jdField_a_of_type_Int - (int)paramContext.getResources().getDimension(2131296907));
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
  
  private LinearLayout a(asow paramasow)
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
    ((Button)localObject).setId(2131365250);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839325));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.jdField_a_of_type_Float * 30.0F), 0, (int)(this.jdField_a_of_type_Float * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramasow.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
    paramasow.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    paramasow.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject);
    return localLinearLayout;
  }
  
  private void b(View paramView, aspq paramaspq)
  {
    if ((paramView == null) || (paramaspq == null))
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
      if (!(paramaspq instanceof asmu)) {
        break label107;
      }
    }
    label107:
    for (paramaspq = (asmu)paramaspq;; paramaspq = null)
    {
      if (paramaspq == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView = (URLImageView)paramView.findViewById(2131365947);
      paramView.setImageDrawable(paramaspq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
      paramView.setVisibility(0);
      return;
      super.a(paramView, paramaspq);
      return;
    }
  }
  
  public View a(aslu paramaslu, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (asow)paramaslu;
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
      LinearLayout localLinearLayout = a((asow)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label377;
      }
      paramView = aspy.a().a(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        paramaslu = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 7, this.jdField_a_of_type_Int);
        if (!this.jdField_a_of_type_Boolean) {
          break label497;
        }
        a(11, paramaslu);
        paramViewGroup.addView(paramaslu, new FrameLayout.LayoutParams(-1, this.f));
        paramViewGroup.addView(localLinearLayout);
        ((asow)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout = ((EmotionInvalidPanelLinearLayout)paramaslu);
        paramViewGroup.setTag(localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((asow)localObject).jdField_a_of_type_AndroidWidgetButton;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((asow)localObject).jdField_a_of_type_AndroidWidgetLinearLayout;
      paramView = anzj.a(2131703004);
      paramaslu = anzj.a(2131703006);
      if (this.g == 2) {
        paramaslu = anzj.a(2131703007);
      }
      paramaslu = anzj.a(2131703000) + paramaslu + "专享,\n开通" + paramaslu + anzj.a(2131703003);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 6) {
        break label507;
      }
      paramaslu = anzj.a(2131703002);
      paramView = anzj.a(2131702997);
      ((asow)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramaslu);
      ((asow)localObject).jdField_a_of_type_AndroidWidgetButton.setText(paramView);
      ((asow)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      paramaslu = ((asow)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout;
      int i1 = paramaslu.getChildCount();
      j = 0;
      if (j >= i1) {
        break label663;
      }
      paramView = (LinearLayout)paramaslu.getChildAt(j);
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
      paramaslu = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
      paramaslu = paramView;
      break;
      paramView = aspy.a().a(10);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from inflater");
        }
        paramaslu = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 4, this.jdField_a_of_type_Int);
        break;
      }
      paramaslu = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from cache");
      paramaslu = paramView;
      break;
      a(10, paramaslu);
      break label104;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 2)
      {
        paramaslu = anzj.a(2131702999);
        paramView = anzj.a(2131703001);
        break label258;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 3) {
        break label258;
      }
      paramaslu = anzj.a(2131702998);
      paramView = anzj.a(2131703005);
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
      b((View)localObject, (aspq)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    label663:
    return paramViewGroup;
  }
  
  public aslu a()
  {
    return new asow();
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
    if (paramView.getId() == 2131365250)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
        break label35;
      }
      QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
    }
    label35:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
          break;
        }
        Object localObject = "mvip.gexinghua.android.sbp_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
        String str = "!vip";
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
          str = "!svip";
        }
        str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
        }
        if (!this.jdField_a_of_type_Boolean) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
    for (;;)
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asov
 * JD-Core Version:    0.7.0.1
 */