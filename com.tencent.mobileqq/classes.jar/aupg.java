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

public class aupg
  extends RecyclerView.Adapter<aupi>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public aupg(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131693090;
    }
    return 2131693093;
  }
  
  private void a(aupi paramaupi)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramaupi.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramaupi.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramaupi.a().setTextColor(this.b);
      paramaupi.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramaupi)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramaupi);
    }
  }
  
  public aupi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aupi(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559277, null, false));
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
  
  public void a(aupi paramaupi, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (localStAppPlayingInfo != null)
    {
      bool = aupj.a(localStAppPlayingInfo.appMetaInfo);
      paramaupi.itemView.setOnClickListener(new auph(this, localStAppPlayingInfo, bool));
      paramaupi.a().setVisibility(0);
      paramaupi.a().setVisibility(0);
      paramaupi.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramaupi.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramaupi.a().setImageDrawable(MiniAppUtils.getIcon(paramaupi.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramaupi.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label271;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label228;
      }
      paramaupi.b().setText(2131693085);
      paramaupi.a().setText(a(bool));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramaupi);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaupi, paramInt, getItemId(paramInt));
      return;
      label228:
      TextView localTextView = paramaupi.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (int i = 2131693087;; i = 2131693086)
      {
        localTextView.setText(i);
        break;
      }
      label271:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramaupi.b().setText(String.format(paramaupi.itemView.getContext().getString(2131693088), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramaupi.a().setText(a(bool));
      }
      else
      {
        paramaupi.a().setVisibility(8);
        paramaupi.a().setVisibility(8);
        paramaupi.b().setVisibility(8);
        paramaupi.a().setText(a(bool));
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
 * Qualified Name:     aupg
 * JD-Core Version:    0.7.0.1
 */