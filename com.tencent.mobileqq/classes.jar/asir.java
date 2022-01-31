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

public class asir
  extends RecyclerView.Adapter<asit>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public asir(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a(asit paramasit)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramasit.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramasit.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramasit.a().setTextColor(this.b);
      paramasit.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramasit)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramasit);
    }
  }
  
  public asit a(ViewGroup paramViewGroup, int paramInt)
  {
    return new asit(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559198, null, false));
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
  
  public void a(asit paramasit, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStAppPlayingInfo != null)
    {
      paramasit.itemView.setOnClickListener(new asis(this, localStAppPlayingInfo));
      paramasit.a().setVisibility(0);
      paramasit.a().setVisibility(0);
      paramasit.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramasit.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramasit.a().setImageDrawable(MiniAppUtils.getIcon(paramasit.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramasit.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label230;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label189;
      }
      paramasit.b().setText(2131693732);
      paramasit.a().setText(2131693737);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramasit);
      }
      return;
      label189:
      TextView localTextView = paramasit.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (paramInt = 2131693734;; paramInt = 2131693733)
      {
        localTextView.setText(paramInt);
        break;
      }
      label230:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramasit.b().setText(String.format(paramasit.itemView.getContext().getString(2131693735), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramasit.a().setText(2131693737);
      }
      else
      {
        paramasit.a().setVisibility(8);
        paramasit.a().setVisibility(8);
        paramasit.b().setVisibility(8);
        paramasit.a().setText(2131693737);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asir
 * JD-Core Version:    0.7.0.1
 */