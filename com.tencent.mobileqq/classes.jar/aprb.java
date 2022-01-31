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
import com.tencent.widget.ThemeImageView;
import java.util.List;

public class aprb
  extends RecyclerView.Adapter<aprd>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public aprb(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a(aprd paramaprd)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramaprd.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramaprd.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramaprd.a().setTextColor(this.b);
      paramaprd.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramaprd)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramaprd);
    }
  }
  
  public aprd a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aprd(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493587, null, false));
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
  
  public void a(aprd paramaprd, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStAppPlayingInfo != null)
    {
      paramaprd.itemView.setOnClickListener(new aprc(this, localStAppPlayingInfo));
      paramaprd.a().setVisibility(0);
      paramaprd.a().setVisibility(0);
      paramaprd.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramaprd.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramaprd.a().setImageDrawable(MiniAppUtils.getIcon(paramaprd.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramaprd.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label230;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label189;
      }
      paramaprd.b().setText(2131627984);
      paramaprd.a().setText(2131627989);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramaprd);
      }
      return;
      label189:
      TextView localTextView = paramaprd.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (paramInt = 2131627986;; paramInt = 2131627985)
      {
        localTextView.setText(paramInt);
        break;
      }
      label230:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramaprd.b().setText(String.format(paramaprd.itemView.getContext().getString(2131627987), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramaprd.a().setText(2131627989);
      }
      else
      {
        paramaprd.a().setVisibility(8);
        paramaprd.a().setVisibility(8);
        paramaprd.b().setVisibility(8);
        paramaprd.a().setText(2131627989);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aprb
 * JD-Core Version:    0.7.0.1
 */