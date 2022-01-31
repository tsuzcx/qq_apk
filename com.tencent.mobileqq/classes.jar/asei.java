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

public class asei
  extends RecyclerView.Adapter<asek>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public asei(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a(asek paramasek)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramasek.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramasek.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramasek.a().setTextColor(this.b);
      paramasek.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramasek)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramasek);
    }
  }
  
  public asek a(ViewGroup paramViewGroup, int paramInt)
  {
    return new asek(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559199, null, false));
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
  
  public void a(asek paramasek, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localStAppPlayingInfo != null)
    {
      paramasek.itemView.setOnClickListener(new asej(this, localStAppPlayingInfo));
      paramasek.a().setVisibility(0);
      paramasek.a().setVisibility(0);
      paramasek.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramasek.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramasek.a().setImageDrawable(MiniAppUtils.getIcon(paramasek.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramasek.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label230;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label189;
      }
      paramasek.b().setText(2131693730);
      paramasek.a().setText(2131693735);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramasek);
      }
      return;
      label189:
      TextView localTextView = paramasek.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (paramInt = 2131693732;; paramInt = 2131693731)
      {
        localTextView.setText(paramInt);
        break;
      }
      label230:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramasek.b().setText(String.format(paramasek.itemView.getContext().getString(2131693733), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramasek.a().setText(2131693735);
      }
      else
      {
        paramasek.a().setVisibility(8);
        paramasek.a().setVisibility(8);
        paramasek.b().setVisibility(8);
        paramasek.a().setText(2131693735);
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
 * Qualified Name:     asei
 * JD-Core Version:    0.7.0.1
 */