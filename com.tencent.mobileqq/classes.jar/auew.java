import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.SectorProgressView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class auew
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public HiBoomTextView a;
  public SectorProgressView a;
  public boolean a;
  public ImageView b;
  public ImageView c;
  
  public auew(HiBoomPanelView paramHiBoomPanelView, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)paramView.findViewById(2131368061));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setLoadingScale(0.6F);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368059));
      this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView = ((SectorProgressView)paramView.findViewById(2131368060));
      this.b = ((ImageView)paramView.findViewById(2131368056));
      this.c = ((ImageView)paramView.findViewById(2131368057));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368054));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368058));
      paramView.setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.getVisibility() == 0) {
      if (!this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.a();
        this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView.setProgress(0);
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Auev.a(this.jdField_a_of_type_Int);
        auen.a.a(i);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      Object localObject1;
      if (this.b.getVisibility() == 0)
      {
        switch (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Auev.a(this.jdField_a_of_type_Int))
        {
        default: 
          break;
        case -1: 
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin();
          if (this.c.getVisibility() == 0) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", (String)localObject1);
            this.c.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
            localObject1 = bgev.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomPanelView", 2, "enter hiboom mall url = " + (String)localObject1);
            }
            VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), (String)localObject1, 4096L, null, false, -1);
            break;
          }
        }
      }
      else if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomPanelView", 2, "dirty filter ");
        }
      }
      else
      {
        if (auen.b.compareAndSet(false, true))
        {
          localObject1 = (anaj)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(13);
          localObject2 = (auen)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(219);
          i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Auev.a(this.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick hiboomid = " + i);
          }
          if (((auen)localObject2).c.contains(Integer.valueOf(i))) {
            ((anaj)localObject1).a(i, true, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a());
          }
          for (;;)
          {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
            break;
            ((anaj)localObject1).a(i, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a(), 2);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick is sending");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auew
 * JD-Core Version:    0.7.0.1
 */