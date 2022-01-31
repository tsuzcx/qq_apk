import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

public class aqru
  extends aqrt
{
  private ImageView a;
  
  public aqru(Context paramContext, View paramView, ViewGroup paramViewGroup)
  {
    super(paramContext, paramView, paramViewGroup);
    this.a = ((ImageView)paramView.findViewById(2131363042));
  }
  
  public void a(FeedsItemData paramFeedsItemData)
  {
    this.itemView.setBackgroundDrawable(aqsv.a(this.itemView.getContext(), 8.0F, 8.0F, 8.0F, 8.0F));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.itemView.getResources().getDrawable(2130846170);
    localURLDrawableOptions.mFailedDrawable = this.itemView.getResources().getDrawable(2130846170);
    this.a.setImageDrawable(URLDrawable.getDrawable(paramFeedsItemData.coverImgUrl, localURLDrawableOptions));
    this.a.setOnClickListener(new aqrv(this, paramFeedsItemData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqru
 * JD-Core Version:    0.7.0.1
 */