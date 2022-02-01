import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqdq
  extends RecyclerView.Adapter<aqdu>
{
  private aqdt jdField_a_of_type_Aqdt;
  private aqeh jdField_a_of_type_Aqeh;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aqdu a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aqdu(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558913, paramViewGroup, false));
  }
  
  public void a(aqdt paramaqdt)
  {
    this.jdField_a_of_type_Aqdt = paramaqdt;
  }
  
  public void a(aqdu paramaqdu, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    aqcb.a(localColorNote).a(paramaqdu, paramInt, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    if (aqda.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = aini.a(localColorNote);
      j = bggq.a(paramaqdu.a.getContext(), 200.0F);
      i = 0;
      if (aqda.c(localColorNote)) {
        i = bggq.a(paramaqdu.a.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramaqdu.a.setMaxWidth(j);
      bdol.a(paramaqdu.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaqdu, paramInt, getItemId(paramInt));
      return;
      label140:
      bdol.a(paramaqdu.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public void a(aqeh paramaqeh)
  {
    this.jdField_a_of_type_Aqeh = paramaqeh;
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
 * Qualified Name:     aqdq
 * JD-Core Version:    0.7.0.1
 */