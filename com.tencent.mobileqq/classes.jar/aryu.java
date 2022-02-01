import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aryu
  extends arwe
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public aryu(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int a(asaf paramasaf)
  {
    int i = 1;
    if (paramasaf == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramasaf.jdField_a_of_type_Int != 7) && (paramasaf.jdField_a_of_type_Int != 10)) {
      return i;
    }
    return 2;
  }
  
  public void a(asaf paramasaf)
  {
    if (paramasaf == null) {}
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
      arxz localarxz = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz;
      int i = a(paramasaf);
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        if ((bool) && (!localarxz.h)) {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847122);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          if ((!((aryb)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).a()) && (this.jdField_a_of_type_Int == 2) && (!localarxz.h))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847111);
            this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt == 13) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.performClick();
      return true;
    }
    if ((paramInt == 14) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.performClick();
      return true;
    }
    return false;
  }
  
  public int[] a()
  {
    return new int[] { 1 };
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void b(asaf paramasaf)
  {
    if (paramasaf == null) {}
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
      arxz localarxz = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz;
      int i = a(paramasaf);
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        if ((bool) && (!localarxz.h)) {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847122);
          continue;
          if ((!((aryb)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).a()) && (this.jdField_a_of_type_Int == 2) && (!localarxz.h))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847111);
            this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Float), 0, 0, 0);
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void d()
  {
    EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localEmoticonMainPanel.findViewById(2131363831));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localEmoticonMainPanel.findViewById(2131363918));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g == 3) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.h) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
    arxd localarxd = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxd;
    switch (paramView.getId())
    {
    }
    int i;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.c(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
      EmojiHomeUiPlugin.openEmosmActivity((BaseActivity)localObject, localQQAppInterface.getAccount(), 1, false, "");
      bcst.b(localQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(false);
      if (i != 0)
      {
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X800AE0F", "0X800AE0F", i, 0, "", "", "", "");
        continue;
        if ((this.jdField_a_of_type_Int != 2) || (bool)) {
          break;
        }
        if (localarxd != null) {
          localarxd.b();
        }
      }
    }
    bcst.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      bcst.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((baif)localQQAppInterface.getManager(36)).b(String.valueOf("100610.100611"));
      ((Context)localObject).getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
    }
    for (bool = true;; bool = false)
    {
      bgtl.a(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Aval.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext, localQQAppInterface.getAccount(), 1, bool, "");
      bcst.b(localQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (localObject != null)
      {
        localObject = ((Context)localObject).getSharedPreferences("emoticon_panel_" + localQQAppInterface.getCurrentAccountUin(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
        }
      }
      if (WebProcessManager.c()) {}
      for (i = 1;; i = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i, 0, "", "");
        bcst.b(localQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(false);
        if (i == 0) {
          break;
        }
        bcst.b(localQQAppInterface, "dc00898", "", "", "0X800AE0E", "0X800AE0E", i, 0, "", "", "", "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryu
 * JD-Core Version:    0.7.0.1
 */