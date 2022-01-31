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

public class aqks
  extends RecyclerView.Adapter<aqku>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public aqks(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a(aqku paramaqku)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramaqku.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramaqku.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramaqku.a().setTextColor(this.b);
      paramaqku.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramaqku)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramaqku);
    }
  }
  
  public aqku a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aqku(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559156, null, false));
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
  
  public void a(aqku paramaqku, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStAppPlayingInfo != null)
    {
      paramaqku.itemView.setOnClickListener(new aqkt(this, localStAppPlayingInfo));
      paramaqku.a().setVisibility(0);
      paramaqku.a().setVisibility(0);
      paramaqku.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramaqku.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramaqku.a().setImageDrawable(MiniAppUtils.getIcon(paramaqku.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramaqku.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label230;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label189;
      }
      paramaqku.b().setText(2131693626);
      paramaqku.a().setText(2131693631);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramaqku);
      }
      return;
      label189:
      TextView localTextView = paramaqku.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (paramInt = 2131693628;; paramInt = 2131693627)
      {
        localTextView.setText(paramInt);
        break;
      }
      label230:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramaqku.b().setText(String.format(paramaqku.itemView.getContext().getString(2131693629), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramaqku.a().setText(2131693631);
      }
      else
      {
        paramaqku.a().setVisibility(8);
        paramaqku.a().setVisibility(8);
        paramaqku.b().setVisibility(8);
        paramaqku.a().setText(2131693631);
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
 * Qualified Name:     aqks
 * JD-Core Version:    0.7.0.1
 */