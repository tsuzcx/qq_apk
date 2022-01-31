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
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class aqxs
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
  
  public aqxs(HiBoomPanelView paramHiBoomPanelView, View paramView, boolean paramBoolean)
  {
    super(paramView);
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = ((HiBoomTextView)paramView.findViewById(2131367511));
      this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setLoadingScale(0.6F);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367509));
      this.jdField_a_of_type_ComTencentMobileqqHiboomSectorProgressView = ((SectorProgressView)paramView.findViewById(2131367510));
      this.b = ((ImageView)paramView.findViewById(2131367506));
      this.c = ((ImageView)paramView.findViewById(2131367507));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131367504));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367508));
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
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Aqxr.a(this.jdField_a_of_type_Int);
        aqxj.a.a(i);
      }
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (this.b.getVisibility() == 0)
        {
          switch (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Aqxr.a(this.jdField_a_of_type_Int))
          {
          default: 
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.c();
          if (this.c.getVisibility() == 0) {}
          for (paramView = "0";; paramView = "1")
          {
            VasWebviewUtil.reportCommercialDrainage((String)localObject, "HighFont", "ClickPlus", "", 1, 0, 0, "", "", paramView);
            this.c.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getPreferences().edit().putBoolean("hiboom_red_dot_show", true).commit();
            paramView = bbqd.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), "font", "mvip.gexinghua.mobile.font.client_tab_store") + "&haibao=1";
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomFont.HiBoomPanelView", 2, "enter hiboom mall url = " + paramView);
            }
            VasWebviewUtil.openQQBrowserWithoutAD(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext(), paramView, 4096L, null, false, -1);
            return;
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HiBoomFont.HiBoomPanelView", 2, "dirty filter ");
      return;
      if (aqxj.b.compareAndSet(false, true))
      {
        paramView = (akfv)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(13);
        localObject = (aqxj)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getManager(219);
        i = this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_Aqxr.a(this.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick hiboomid = " + i);
        }
        if (((aqxj)localObject).c.contains(Integer.valueOf(i))) {
          paramView.a(i, true, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a());
        }
        for (;;)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "CliOper", "", "", "0X80094D7", "0X80094D7", 0, 0, "", "", "", "");
          return;
          paramView.a(i, this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.a(), 2);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("HiBoomFont.HiBoomPanelView", 2, "onClick is sending");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqxs
 * JD-Core Version:    0.7.0.1
 */