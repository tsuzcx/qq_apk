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

public class apmc
  extends RecyclerView.Adapter<apmg>
{
  private apmf jdField_a_of_type_Apmf;
  private apmt jdField_a_of_type_Apmt;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public apmg a(ViewGroup paramViewGroup, int paramInt)
  {
    return new apmg(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558920, paramViewGroup, false));
  }
  
  public void a(apmf paramapmf)
  {
    this.jdField_a_of_type_Apmf = paramapmf;
  }
  
  public void a(apmg paramapmg, int paramInt)
  {
    ColorNote localColorNote = (ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    apkn.a(localColorNote).a(paramapmg, paramInt, this.jdField_a_of_type_Boolean);
    int j;
    int i;
    if (aplm.d(localColorNote))
    {
      UpComingMsgModel localUpComingMsgModel = ahrr.a(localColorNote);
      j = DisplayUtil.dip2px(paramapmg.a.getContext(), 200.0F);
      i = 0;
      if (aplm.c(localColorNote)) {
        i = DisplayUtil.dip2px(paramapmg.a.getContext(), 27.0F);
      }
      if (localUpComingMsgModel.uniseq.size() <= 1) {
        break label140;
      }
      paramapmg.a.setMaxWidth(j);
      TextUtils.compoundEllipsize(paramapmg.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.MIDDLE, "的", i);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramapmg, paramInt, getItemId(paramInt));
      return;
      label140:
      TextUtils.compoundEllipsize(paramapmg.a, localColorNote.getMainTitle(), j, TextUtils.TruncateAt.END, null, i);
    }
  }
  
  public void a(apmt paramapmt)
  {
    this.jdField_a_of_type_Apmt = paramapmt;
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
 * Qualified Name:     apmc
 * JD-Core Version:    0.7.0.1
 */