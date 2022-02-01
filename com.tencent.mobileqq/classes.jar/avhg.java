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

public class avhg
  extends RecyclerView.Adapter<avhi>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public avhg(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131693099;
    }
    return 2131693102;
  }
  
  private void a(avhi paramavhi)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramavhi.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramavhi.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramavhi.a().setTextColor(this.b);
      paramavhi.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramavhi)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramavhi);
    }
  }
  
  public avhi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new avhi(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559277, null, false));
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
  
  public void a(avhi paramavhi, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (localStAppPlayingInfo != null)
    {
      bool = avhj.a(localStAppPlayingInfo.appMetaInfo);
      paramavhi.itemView.setOnClickListener(new avhh(this, localStAppPlayingInfo, bool));
      paramavhi.a().setVisibility(0);
      paramavhi.a().setVisibility(0);
      paramavhi.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramavhi.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramavhi.a().setImageDrawable(MiniAppUtils.getIcon(paramavhi.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramavhi.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label271;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label228;
      }
      paramavhi.b().setText(2131693094);
      paramavhi.a().setText(a(bool));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramavhi);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramavhi, paramInt, getItemId(paramInt));
      return;
      label228:
      TextView localTextView = paramavhi.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (int i = 2131693096;; i = 2131693095)
      {
        localTextView.setText(i);
        break;
      }
      label271:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramavhi.b().setText(String.format(paramavhi.itemView.getContext().getString(2131693097), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramavhi.a().setText(a(bool));
      }
      else
      {
        paramavhi.a().setVisibility(8);
        paramavhi.a().setVisibility(8);
        paramavhi.b().setVisibility(8);
        paramavhi.a().setText(a(bool));
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
 * Qualified Name:     avhg
 * JD-Core Version:    0.7.0.1
 */