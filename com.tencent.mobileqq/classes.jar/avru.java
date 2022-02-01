import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hiboom.HiBoomPanelView;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.SectorProgressView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class avru
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
  
  public avru(HiBoomPanelView paramHiBoomPanelView, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)paramView.findViewById(2131368026));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setLoadingScale(0.6F);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368024));
      this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView = ((SectorProgressView)paramView.findViewById(2131368025));
      this.b = ((ImageView)paramView.findViewById(2131368021));
      this.c = ((ImageView)paramView.findViewById(2131368022));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131368019));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368023));
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
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Avrt.a(this.jdField_a_of_type_Int);
        avrl.a.a(i);
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
        switch (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Avrt.a(this.jdField_a_of_type_Int))
        {
        default: 
          break;
        case -1: 
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c();
          if (this.c.getVisibility() == 0) {}
          for (localObject1 = "0";; localObject1 = "1")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject2, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", (String)localObject1);
            this.c.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
            localObject1 = bhyk.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
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
        if (avrl.b.compareAndSet(false, true))
        {
          localObject1 = (aogu)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(13);
          localObject2 = (avrl)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(219);
          i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Avrt.a(this.jdField_a_of_type_Int);
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick hiboomid = " + i);
          }
          if (((avrl)localObject2).c.contains(Integer.valueOf(i))) {
            ((aogu)localObject1).a(i, true, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a());
          }
          for (;;)
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
            break;
            ((aogu)localObject1).a(i, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a(), 2);
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
 * Qualified Name:     avru
 * JD-Core Version:    0.7.0.1
 */