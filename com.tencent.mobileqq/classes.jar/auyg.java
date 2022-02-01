import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;

public class auyg
  extends bjwj
{
  ajej jdField_a_of_type_Ajej;
  auxv jdField_a_of_type_Auxv;
  OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  
  public auyg(OverScrollRecyclerView paramOverScrollRecyclerView, ajej paramajej, auxv paramauxv)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = paramOverScrollRecyclerView;
    this.jdField_a_of_type_Ajej = paramajej;
    this.jdField_a_of_type_Auxv = paramauxv;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if ((paramViewHolder != null) && (paramViewHolder.itemView != null) && ((paramViewHolder instanceof auxz)) && (Build.VERSION.SDK_INT >= 21)) {}
    try
    {
      paramViewHolder.itemView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
      paramViewHolder = paramViewHolder.itemView;
      if (paramBoolean) {}
      for (float f = 20.0F;; f = 0.0F)
      {
        paramViewHolder.setTranslationZ(f);
        return;
      }
      return;
    }
    catch (Exception paramViewHolder)
    {
      QLog.i("leba_sort_LebaTableMgrFragment", 1, "setItemShadow", paramViewHolder);
    }
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    super.clearView(paramRecyclerView, paramViewHolder);
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "clearView");
    a(paramViewHolder, false);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    return makeMovementFlags(15, 0);
  }
  
  public boolean isLongPressDragEnabled()
  {
    return false;
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    int i = paramViewHolder1.getAdapterPosition();
    int j = paramViewHolder2.getAdapterPosition();
    if (this.jdField_a_of_type_Ajej != null) {
      return this.jdField_a_of_type_Ajej.a(paramRecyclerView, i, j);
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    QLog.i("leba_sort_LebaTableMgrFragment", 1, "onSelectedChanged" + paramInt);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.b();
      }
      if (this.jdField_a_of_type_Ajej != null) {
        this.jdField_a_of_type_Ajej.a(this.jdField_a_of_type_Auxv);
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt != 2);
      a(paramViewHolder, true);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView == null);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.a();
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyg
 * JD-Core Version:    0.7.0.1
 */