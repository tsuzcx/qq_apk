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

public class apvo
  extends aptd
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ImageView b;
  
  public apvo(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private int a(apwv paramapwv)
  {
    int i = 1;
    if (paramapwv == null)
    {
      QLog.e("EmoticonPanelSettingHelper", 1, "getMoreBtnStatusByEmotionInfo info = null");
      i = -1;
    }
    while ((paramapwv.jdField_a_of_type_Int != 7) && (paramapwv.jdField_a_of_type_Int != 10)) {
      return i;
    }
    return 2;
  }
  
  public void a()
  {
    EmoticonMainPanel localEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localEmoticonMainPanel.findViewById(2131363631));
    this.b = ((ImageView)localEmoticonMainPanel.findViewById(2131363713));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g == 3) {
      this.b.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apux.h)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a(apwv paramapwv)
  {
    if (paramapwv == null) {}
    do
    {
      boolean bool;
      apux localapux;
      int i;
      do
      {
        return;
        bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
        localapux = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apux;
        i = a(paramapwv);
      } while (this.jdField_a_of_type_Int == i);
      this.jdField_a_of_type_Int = i;
      if ((bool) && (!localapux.h))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846680);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
      }
      if ((this.jdField_a_of_type_Int != 2) || (localapux.h)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846669);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
    return;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public int[] a()
  {
    return new int[] { 1 };
  }
  
  public void b(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
  
  public void b(apwv paramapwv)
  {
    if (paramapwv == null) {}
    do
    {
      boolean bool;
      apux localapux;
      int i;
      do
      {
        return;
        bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
        localapux = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apux;
        i = a(paramapwv);
      } while (this.jdField_a_of_type_Int == i);
      this.jdField_a_of_type_Int = i;
      if ((bool) && (!localapux.h))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846680);
        return;
      }
      if ((this.jdField_a_of_type_Int != 2) || (localapux.h)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846669);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding((int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Float), 0, 0, 0);
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonPanelSettingHelper", 2, "onPageSelected, show del pic");
    return;
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k;
    apuc localapuc = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Apuc;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.c(), "ep_mall", "click_mine", "", 0, 0, 0, "", "", "");
      EmojiHomeUiPlugin.openEmosmActivity((BaseActivity)localContext, localQQAppInterface.getAccount(), 1, false, "");
      azqs.b(localQQAppInterface, "dc00898", "", "", "0x800a56d", "0x800a56d", 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_Int != 2) || (bool)) {
        break;
      }
    } while (localapuc == null);
    localapuc.b();
    return;
    azqs.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B7", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      azqs.b(localQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B9", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((axlx)localQQAppInterface.getManager(36)).b(String.valueOf("100610.100611"));
      localContext.getSharedPreferences("mobileQQ", 0).edit().putBoolean("emo_panel_mall_new_played", false).apply();
    }
    for (bool = true;; bool = false)
    {
      bdom.a(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Astc.b();
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext, localQQAppInterface.getAccount(), 1, bool, "");
      azqs.b(localQQAppInterface, "CliOper", "", "", "0X80047A3", "0X80047A3", 0, 0, "", "", "", "");
      if (localContext != null)
      {
        paramView = localContext.getSharedPreferences("emoticon_panel_" + localQQAppInterface.getCurrentAccountUin(), 0);
        if (paramView != null) {
          paramView.edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).apply();
        }
      }
      if (WebProcessManager.c()) {}
      for (int i = 1;; i = 0)
      {
        VasWebviewUtil.reportVasStatus("personal_web_preload_hit_rit", "emoticon_main_panel_plus", "0", 0, 0, i, 0, "", "");
        azqs.b(localQQAppInterface, "dc00898", "", "", "0x800a56c", "0x800a56c", 0, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvo
 * JD-Core Version:    0.7.0.1
 */