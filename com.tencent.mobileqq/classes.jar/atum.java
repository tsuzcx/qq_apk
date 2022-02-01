import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class atum
  extends RecyclerView.Adapter<atuo>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public atum(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131693161;
    }
    return 2131693164;
  }
  
  private void a(atuo paramatuo)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramatuo.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramatuo.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramatuo.a().setTextColor(this.b);
      paramatuo.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramatuo)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramatuo);
    }
  }
  
  public atuo a(ViewGroup paramViewGroup, int paramInt)
  {
    return new atuo(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559283, null, false));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = paramInt;
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
  }
  
  public void a(atuo paramatuo, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (localStAppPlayingInfo != null)
    {
      bool = atup.a(localStAppPlayingInfo.appMetaInfo);
      paramatuo.itemView.setOnClickListener(new atun(this, localStAppPlayingInfo, bool));
      paramatuo.a().setVisibility(0);
      paramatuo.a().setVisibility(0);
      paramatuo.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramatuo.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramatuo.a().setImageDrawable(MiniAppUtils.getIcon(paramatuo.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramatuo.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label271;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label228;
      }
      paramatuo.b().setText(2131693156);
      paramatuo.a().setText(a(bool));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramatuo);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramatuo, paramInt, getItemId(paramInt));
      return;
      label228:
      TextView localTextView = paramatuo.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (int i = 2131693158;; i = 2131693157)
      {
        localTextView.setText(i);
        break;
      }
      label271:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramatuo.b().setText(String.format(paramatuo.itemView.getContext().getString(2131693159), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramatuo.a().setText(a(bool));
      }
      else
      {
        paramatuo.a().setVisibility(8);
        paramatuo.a().setVisibility(8);
        paramatuo.b().setVisibility(8);
        paramatuo.a().setText(a(bool));
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getItemCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atum
 * JD-Core Version:    0.7.0.1
 */