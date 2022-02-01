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

public class auzm
  extends RecyclerView.Adapter<auzo>
{
  private int jdField_a_of_type_Int = 9999;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final String jdField_a_of_type_JavaLangString;
  private List<MISC.StAppPlayingInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public auzm(List<MISC.StAppPlayingInfo> paramList, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2131693339;
    }
    return 2131693342;
  }
  
  private void a(auzo paramauzo)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentResColorStateList != null)
      {
        paramauzo.a().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        paramauzo.b().setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
        return;
      }
      paramauzo.a().setTextColor(this.b);
      paramauzo.b().setTextColor(this.b);
      return;
    }
    catch (Throwable paramauzo)
    {
      QLog.e("IntimatePlayTogetherMin", 1, "updateThemeTextColor error", paramauzo);
    }
  }
  
  public auzo a(ViewGroup paramViewGroup, int paramInt)
  {
    return new auzo(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559334, null, false));
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
  
  public void a(auzo paramauzo, int paramInt)
  {
    MISC.StAppPlayingInfo localStAppPlayingInfo = (MISC.StAppPlayingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (localStAppPlayingInfo != null)
    {
      bool = auzp.a(localStAppPlayingInfo.appMetaInfo);
      paramauzo.itemView.setOnClickListener(new auzn(this, localStAppPlayingInfo, bool));
      paramauzo.a().setVisibility(0);
      paramauzo.a().setVisibility(0);
      paramauzo.b().setVisibility(0);
      if (localStAppPlayingInfo.appMetaInfo != null)
      {
        paramauzo.a().setText(localStAppPlayingInfo.appMetaInfo.appName.get());
        paramauzo.a().setImageDrawable(MiniAppUtils.getIcon(paramauzo.a().getContext(), localStAppPlayingInfo.appMetaInfo.icon.get(), true));
      }
      IntimatePlayTogetherMiniGameCardView.a(paramauzo.a(), this.jdField_a_of_type_JavaLangString);
      if ((localStAppPlayingInfo.myRank.get() == 0) || (localStAppPlayingInfo.friendRank.get() == 0)) {
        break label271;
      }
      if (localStAppPlayingInfo.myRank.get() != localStAppPlayingInfo.friendRank.get()) {
        break label228;
      }
      paramauzo.b().setText(2131693334);
      paramauzo.a().setText(a(bool));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a(paramauzo);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramauzo, paramInt, getItemId(paramInt));
      return;
      label228:
      TextView localTextView = paramauzo.b();
      if (localStAppPlayingInfo.myRank.get() < localStAppPlayingInfo.friendRank.get()) {}
      for (int i = 2131693336;; i = 2131693335)
      {
        localTextView.setText(i);
        break;
      }
      label271:
      if ((localStAppPlayingInfo.myRank.get() == 0) && (localStAppPlayingInfo.friendRank.get() > 0))
      {
        paramauzo.b().setText(String.format(paramauzo.itemView.getContext().getString(2131693337), new Object[] { Integer.valueOf(localStAppPlayingInfo.friendRank.get()) }));
        paramauzo.a().setText(a(bool));
      }
      else
      {
        paramauzo.a().setVisibility(8);
        paramauzo.a().setVisibility(8);
        paramauzo.b().setVisibility(8);
        paramauzo.a().setText(a(bool));
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
 * Qualified Name:     auzm
 * JD-Core Version:    0.7.0.1
 */