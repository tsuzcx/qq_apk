import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1;
import com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.2;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class asoj
  extends asls
  implements View.OnClickListener
{
  private ImageView a;
  
  public asoj(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private assh a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList;
    EmotionPanelViewPagerAdapter localEmotionPanelViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    if ((localObject != null) && (((List)localObject).size() > 0) && (localEmotionPanelViewPagerAdapter != null))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aslt localaslt = localEmotionPanelViewPagerAdapter.a((aspt)((Iterator)localObject).next());
        if ((localaslt instanceof assh)) {
          return (assh)localaslt;
        }
      }
    }
    return null;
  }
  
  void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext;
    if (localQQAppInterface == null) {}
    while (!ApolloUtil.c()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131362360);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838005);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) {
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = agej.a(52.0F, localContext.getResources());
    localLayoutParams.rightMargin = agej.a(15.0F, localContext.getResources());
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    ApolloUtil.b();
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_view", 0, 0, new String[0]);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0) {
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (EmoticonPanelController.jdField_b_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(7))
    {
      assh localassh = a();
      if (localassh != null) {
        localassh.a(paramInt1, paramInt2);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().a = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a().jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g(7);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.E();
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 8, 3 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "[removePopupGuide]");
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "refresh fav emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.1(this), 200L);
  }
  
  public void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = (asmn)((QQAppInterface)localObject).getManager(172);
      if (localObject != null) {
        ((asmn)localObject).b();
      }
    }
    b();
  }
  
  @TargetApi(11)
  public void l()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbav)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(String.valueOf("100610.100611"));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelSystemAndEmojiHelper", 2, "emoji mall has redpoint.");
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B8", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).getBoolean("emo_panel_mall_new_played", false)) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelSystemAndEmojiHelper.2(this), 200L);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      assh localassh = a();
      if (localassh != null) {
        localassh.d();
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "expresstab_bubble_click", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asoj
 * JD-Core Version:    0.7.0.1
 */