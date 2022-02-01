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

public class asoi
  extends asls
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  
  public asoi(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int a(aspt paramaspt)
  {
    int i = 1;
    if (paramaspt == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramaspt.jdField_a_of_type_Int != 7) && (paramaspt.jdField_a_of_type_Int != 10)) {
      return i;
    }
    return 2;
  }
  
  public void a(aspt paramaspt)
  {
    if (paramaspt == null) {}
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
      asnn localasnn = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Asnn;
      int i = a(paramaspt);
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        if ((bool) && (!localasnn.h)) {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847139);
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          continue;
          if ((!((asnp)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).a()) && (this.jdField_a_of_type_Int == 2) && (!localasnn.h))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847128);
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
  
  public void b(aspt paramaspt)
  {
    if (paramaspt == null) {}
    for (;;)
    {
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
      asnn localasnn = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Asnn;
      int i = a(paramaspt);
      if (this.jdField_a_of_type_Int != i)
      {
        this.jdField_a_of_type_Int = i;
        if ((bool) && (!localasnn.h)) {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847139);
          continue;
          if ((!((asnp)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(1)).a()) && (this.jdField_a_of_type_Int == 2) && (!localasnn.h))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847128);
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localEmoticonMainPanel.findViewById(2131363855));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localEmoticonMainPanel.findViewById(2131363942));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g == 3) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Asnn.h) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l))
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
    asmr localasmr = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Asmr;
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
      bdll.b(localQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(false);
      if (i != 0)
      {
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X800AE0F", "0X800AE0F", i, 0, "", "", "", "");
        continue;
        if ((this.jdField_a_of_type_Int != 2) || (bool)) {
          break;
        }
        if (localasmr != null) {
          localasmr.b();
        }
      }
    }
    bdll.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      bdll.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((bbav)localQQAppInterface.getManager(36)).b(String.valueOf("100610.100611"));
      ((Context)localObject).getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
    }
    for (bool = true;; bool = false)
    {
      bhto.a(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Avsm.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext, localQQAppInterface.getAccount(), 1, bool, "");
      bdll.b(localQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
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
        bdll.b(localQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(false);
        if (i == 0) {
          break;
        }
        bdll.b(localQQAppInterface, "dc00898", "", "", "0X800AE0E", "0X800AE0E", i, 0, "", "", "", "");
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoi
 * JD-Core Version:    0.7.0.1
 */