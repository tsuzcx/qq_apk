import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqpg
  extends RecyclerView.Adapter<aqpk>
{
  private aqpj jdField_a_of_type_Aqpj;
  private aqpx jdField_a_of_type_Aqpx;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aqpk a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aqpk(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558947, paramViewGroup, false));
  }
  
  public void a(aqpj paramaqpj)
  {
    this.jdField_a_of_type_Aqpj = paramaqpj;
  }
  
  public void a(aqpk paramaqpk, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    aqnr.a(localColorNote).a(paramaqpk, paramInt, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    if (aqoq.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = aimq.a(localColorNote);
      j = DisplayUtil.dip2px(paramaqpk.a.getContext(), 200.0F);
      i = 0;
      if (aqoq.c(localColorNote)) {
        i = DisplayUtil.dip2px(paramaqpk.a.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramaqpk.a.setMaxWidth(j);
      TextUtils.compoundEllipsize(paramaqpk.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaqpk, paramInt, getItemId(paramInt));
      return;
      label140:
      TextUtils.compoundEllipsize(paramaqpk.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public void a(aqpx paramaqpx)
  {
    this.jdField_a_of_type_Aqpx = paramaqpx;
  }
  
  void a(List<ColorNote> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpg
 * JD-Core Version:    0.7.0.1
 */