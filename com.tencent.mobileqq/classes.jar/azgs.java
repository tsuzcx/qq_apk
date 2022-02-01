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

public class azgs
  implements azfb, azfw
{
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  private azfb jdField_a_of_type_Azfb;
  private azgo jdField_a_of_type_Azgo;
  private VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public azgs(azfb paramazfb)
  {
    this.jdField_a_of_type_Azfb = paramazfb;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558705, null);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)this.jdField_a_of_type_AndroidViewView.findViewById(2131377557));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372358));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372359));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363011));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377556);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380937));
    d();
    e();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new azgt(this));
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
    this.jdField_a_of_type_Azgo = new azgo(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Azgo.a(this);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Azgo);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelDragListener(this);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Azgo != null) {
      return this.jdField_a_of_type_Azgo.a();
    }
    return 3;
  }
  
  public View a()
  {
    c();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public azfk a()
  {
    if (this.jdField_a_of_type_Azgo != null) {
      return this.jdField_a_of_type_Azgo.a();
    }
    return null;
  }
  
  public List<azfv> a()
  {
    if (this.jdField_a_of_type_Azgo != null) {
      return this.jdField_a_of_type_Azgo.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azfb != null) {
      this.jdField_a_of_type_Azfb.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Azfb != null) {
      this.jdField_a_of_type_Azfb.a(paramInt);
    }
  }
  
  public void a(azfk paramazfk, List<azfv> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceView", 2, "showCommandView infoList is empty");
      }
    }
    while (this.jdField_a_of_type_Azgo == null) {
      return;
    }
    this.jdField_a_of_type_Azgo.a(paramazfk, paramList);
  }
  
  public void a(azfm paramazfm)
  {
    if (this.jdField_a_of_type_Azfb != null) {
      this.jdField_a_of_type_Azfb.a(paramazfm);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azfb != null) {
      this.jdField_a_of_type_Azfb.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.a());
  }
  
  public void b()
  {
    this.jdField_a_of_type_Azgo = null;
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
 * Qualified Name:     azgs
 * JD-Core Version:    0.7.0.1
 */