import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean.FilterID;
import java.util.List;

public class bloa
  extends RecyclerView.Adapter<blod>
{
  private int jdField_a_of_type_Int;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bloc jdField_a_of_type_Bloc;
  private List<AEEditorFilterBean> jdField_a_of_type_JavaUtilList;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public bloa(List<AEEditorFilterBean> paramList, int paramInt, bloc parambloc)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.g = paramInt;
    this.jdField_a_of_type_Bloc = parambloc;
  }
  
  private void b(int paramInt)
  {
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
    int i = localLinearLayoutManager.findFirstVisibleItemPosition();
    i = (localLinearLayoutManager.findLastVisibleItemPosition() - i + 1) / 2 + i;
    if (paramInt > i) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(blpy.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 100.0F), 0);
    }
    while (paramInt >= i) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollBy(-blpy.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getContext(), 100.0F), 0);
  }
  
  public int a()
  {
    return this.g;
  }
  
  @NonNull
  public blod a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new blod(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558534, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(@NonNull blod paramblod, int paramInt)
  {
    AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    if (paramInt == this.g)
    {
      i = 1;
      if (i == 0) {
        break label136;
      }
      paramblod.b.setVisibility(0);
      paramblod.b.setBackgroundColor(this.jdField_a_of_type_Int);
      paramblod.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramblod.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.e);
      paramblod.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(this.jdField_a_of_type_Int);
      label79:
      if (localAEEditorFilterBean.type != AEEditorFilterBean.FilterID.NON) {
        break label201;
      }
      paramblod.jdField_a_of_type_AndroidWidgetTextView.setText(2131692663);
      if (i == 0) {
        break label178;
      }
      paramblod.b.setImageResource(2130837654);
    }
    for (;;)
    {
      paramblod.itemView.setOnClickListener(new blob(this, localAEEditorFilterBean, paramInt));
      return;
      i = 0;
      break;
      label136:
      paramblod.b.setVisibility(8);
      paramblod.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramblod.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.f);
      paramblod.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(this.d);
      break label79;
      label178:
      paramblod.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837655);
      paramblod.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.c);
      continue;
      label201:
      if (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.AIFilter)
      {
        paramblod.jdField_a_of_type_AndroidWidgetTextView.setText(2131692661);
        if (i != 0)
        {
          paramblod.b.setImageResource(2130837651);
        }
        else
        {
          paramblod.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837652);
          paramblod.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(this.b);
        }
      }
      else if (localAEEditorFilterBean.type == AEEditorFilterBean.FilterID.Comics)
      {
        paramblod.jdField_a_of_type_AndroidWidgetTextView.setText(2131692662);
        if (i != 0) {
          paramblod.b.setImageResource(2130837653);
        } else {
          xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
        }
      }
      else
      {
        paramblod.jdField_a_of_type_AndroidWidgetTextView.setText(localAEEditorFilterBean.getName());
        if (i != 0) {
          paramblod.b.setImageResource(2130837656);
        } else {
          xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView, localAEEditorFilterBean.getPicUrl(), xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), xsm.a(paramblod.jdField_a_of_type_AndroidWidgetImageView.getContext(), 67.0F), null, null);
        }
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Int = paramRecyclerView.getResources().getColor(2131165233);
    this.b = paramRecyclerView.getResources().getColor(2131165237);
    this.c = paramRecyclerView.getResources().getColor(2131165238);
    this.d = paramRecyclerView.getResources().getColor(2131165234);
    this.e = paramRecyclerView.getResources().getColor(2131165235);
    this.f = paramRecyclerView.getResources().getColor(2131165236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloa
 * JD-Core Version:    0.7.0.1
 */