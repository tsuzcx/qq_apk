import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bana
  implements baks, baln
{
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private baks jdField_a_of_type_Baks;
  private bamw jdField_a_of_type_Bamw;
  private VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public bana(baks parambaks)
  {
    this.jdField_a_of_type_Baks = parambaks;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558717, null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377831));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372551));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372552));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363028));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377830);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381289));
    d();
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new banb(this));
  }
  
  private void c(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void d()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 1, false);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_Bamw = new bamw(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Bamw.a(this);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bamw);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelDragListener(this);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Bamw != null) {
      return this.jdField_a_of_type_Bamw.a();
    }
    return 3;
  }
  
  public View a()
  {
    c();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public balb a()
  {
    if (this.jdField_a_of_type_Bamw != null) {
      return this.jdField_a_of_type_Bamw.a();
    }
    return null;
  }
  
  public List<balm> a()
  {
    if (this.jdField_a_of_type_Bamw != null) {
      return this.jdField_a_of_type_Bamw.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Baks != null) {
      this.jdField_a_of_type_Baks.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Baks != null) {
      this.jdField_a_of_type_Baks.a(paramInt);
    }
  }
  
  public void a(balb parambalb, List<balm> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceView", 2, "showCommandView infoList is empty");
      }
    }
    while (this.jdField_a_of_type_Bamw == null) {
      return;
    }
    this.jdField_a_of_type_Bamw.a(parambalb, paramList);
  }
  
  public void a(bald parambald)
  {
    if (this.jdField_a_of_type_Baks != null) {
      this.jdField_a_of_type_Baks.a(parambald);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Baks != null) {
      this.jdField_a_of_type_Baks.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.a());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bamw = null;
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bana
 * JD-Core Version:    0.7.0.1
 */