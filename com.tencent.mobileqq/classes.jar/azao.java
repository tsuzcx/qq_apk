import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder;

public class azao
  extends azbp<ArithmeticViewHolder, ayzx>
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArithmeticViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder;
  
  public azao(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public ArithmeticViewHolder a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder = new ArithmeticViewHolder(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495553, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder;
  }
  
  public void a(View paramView, ArithmeticViewHolder paramArithmeticViewHolder) {}
  
  public void a(ayzx paramayzx)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiArithmeticViewHolder.a(true);
    }
  }
  
  public void a(ArithmeticViewHolder paramArithmeticViewHolder, ayzx paramayzx, int paramInt)
  {
    paramArithmeticViewHolder.a(paramayzx, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramArithmeticViewHolder.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azao
 * JD-Core Version:    0.7.0.1
 */