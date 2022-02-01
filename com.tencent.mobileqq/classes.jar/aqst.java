import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgModel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aqst
  extends RecyclerView.Adapter<aqsx>
{
  private aqsw jdField_a_of_type_Aqsw;
  private aqtk jdField_a_of_type_Aqtk;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aqsx a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aqsx(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558912, paramViewGroup, false));
  }
  
  public void a(aqsw paramaqsw)
  {
    this.jdField_a_of_type_Aqsw = paramaqsw;
  }
  
  public void a(aqsx paramaqsx, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    aqre.a(localColorNote).a(paramaqsx, paramInt, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    if (aqsd.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = aixg.a(localColorNote);
      j = bhgr.a(paramaqsx.a.getContext(), 200.0F);
      i = 0;
      if (aqsd.c(localColorNote)) {
        i = bhgr.a(paramaqsx.a.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramaqsx.a.setMaxWidth(j);
      behh.a(paramaqsx.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaqsx, paramInt, getItemId(paramInt));
      return;
      label140:
      behh.a(paramaqsx.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public void a(aqtk paramaqtk)
  {
    this.jdField_a_of_type_Aqtk = paramaqtk;
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
 * Qualified Name:     aqst
 * JD-Core Version:    0.7.0.1
 */