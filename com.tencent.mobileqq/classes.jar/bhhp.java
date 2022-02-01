import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.AdViewManager;
import com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bhhp
  extends ShareActionSheetBuilder
{
  protected Bitmap a;
  
  public bhhp(Context paramContext)
  {
    super(paramContext, false);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.mIsDataChanged = true;
  }
  
  public View createViewFlipper()
  {
    View localView = View.inflate(this.mOutAct, 2131562869, null);
    this.mAdViewManager.setAdContainer((RelativeLayout)localView.findViewById(2131362221));
    this.mTitleTv = ((TextView)localView.findViewById(2131361976));
    Object localObject2;
    Object localObject1;
    if (this.showTitle)
    {
      this.mTitleTv.setVisibility(0);
      if (this.dialogTitle != null) {
        this.mTitleTv.setText(this.dialogTitle);
      }
      this.mScrollView1 = ((ElasticHorScrView)localView.findViewById(2131377144));
      this.mScrollView2 = ((ElasticHorScrView)localView.findViewById(2131377145));
      localObject2 = getActionSheetItems();
      if (localObject2.length <= 0) {
        break label390;
      }
      localObject1 = localObject2[0];
      label122:
      if (!((List)localObject1).isEmpty()) {
        break label1203;
      }
    }
    label147:
    label1186:
    label1192:
    label1195:
    label1198:
    label1203:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label1198;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.mOutAct.getResources().getDimensionPixelSize(2131299008));
        Object localObject4 = new StaticLayout(breakLabel2((TextPaint)localObject3, this.itemTextWidth, getLongestLabel((List)localObject1), 5), (TextPaint)localObject3, this.itemTextWidth, Layout.Alignment.ALIGN_CENTER, 1.0F, this.textSpacingExtra, true);
        StaticLayout localStaticLayout = new StaticLayout(breakLabel2((TextPaint)localObject3, this.itemTextWidth, getLongestLabel((List)localObject2), 5), (TextPaint)localObject3, this.itemTextWidth, Layout.Alignment.ALIGN_CENTER, 1.0F, this.textSpacingExtra, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.mOutAct.getResources().getDimensionPixelOffset(2131296795);
        int i;
        if (j != 0)
        {
          this.grid_row_view1 = ((GridView)localView.findViewById(2131367851));
          if (Build.VERSION.SDK_INT >= 9) {
            this.mScrollView1.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label350:
          if (((Iterator)localObject4).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).visibility != 0) {
              break label1195;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label350;
          hideTitle();
          break;
          localObject1 = new ArrayList(0);
          break label122;
          localObject2 = new ArrayList(0);
          break label147;
          int n = this.itemMargin + getIconWidth() + this.itemMargin;
          this.grid_row_view1.setColumnWidth(n);
          this.grid_row_view1.setNumColumns(i);
          localObject4 = this.grid_row_view1.getLayoutParams();
          this.grid_row_view1.setPadding(this.scrollViewMargin, this.grid_row_view1.getPaddingTop(), this.scrollViewMargin, this.grid_row_view1.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.scrollViewMargin + this.scrollViewMargin);
          this.mGridView1Length = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.itemImageSize + this.itemTextMargin + ((StaticLayout)localObject3).getHeight() + m);
          this.grid_row_view1.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.grid_row_view1.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.mOutAct, (List)localObject1));
          this.grid_row_view1.setSelector(new ColorDrawable(0));
          this.grid_row_view1.setOnItemClickListener(this.clickListener);
          if (k != 0)
          {
            this.grid_row_view2 = ((GridView)localView.findViewById(2131367852));
            if (Build.VERSION.SDK_INT >= 9) {
              this.mScrollView2.setOverScrollMode(2);
            }
            this.grid_row_view2.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject1).next()).visibility != 0) {
                break label1192;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.itemMargin + getIconWidth() + this.itemMargin;
            this.grid_row_view2.setColumnWidth(n);
            this.grid_row_view2.setNumColumns(i);
            localObject1 = this.grid_row_view2.getLayoutParams();
            this.grid_row_view2.setPadding(this.scrollViewMargin, this.grid_row_view2.getPaddingTop(), this.scrollViewMargin, this.grid_row_view2.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.scrollViewMargin + this.scrollViewMargin);
            this.mGridView2Length = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.itemImageSize + this.itemTextMargin + ((StaticLayout)localObject3).getHeight() + m);
            this.grid_row_view2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.grid_row_view2.setNumColumns(i);
            this.grid_row_view2.setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.mOutAct, (List)localObject2));
            this.grid_row_view2.setSelector(new ColorDrawable(0));
            this.grid_row_view2.setOnItemClickListener(this.clickListener);
            localObject1 = (TextView)localView.findViewById(2131361968);
            ((TextView)localObject1).setText(2131690697);
            ((TextView)localObject1).setOnClickListener(new bhhq(this));
            if (j == 0) {
              this.mScrollView1.setVisibility(8);
            }
            if (k == 0) {
              this.mScrollView2.setVisibility(8);
            }
            localView.post(new ShareWithPictureActionSheetBuilder.2(this));
            j = ViewUtils.dip2px(90.0F);
            i = j;
            if (this.grid_row_view1 != null) {
              i = j + this.grid_row_view1.getLayoutParams().height;
            }
            if (this.grid_row_view2 != null) {
              i += this.grid_row_view2.getLayoutParams().height;
            }
            for (;;)
            {
              k = this.mOutAct.getResources().getDisplayMetrics().widthPixels;
              j = this.mOutAct.getResources().getDisplayMetrics().heightPixels;
              localObject1 = (RelativeLayout)localView.findViewById(2131377553);
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = (j - i);
              ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              if (this.a != null)
              {
                m = ViewUtils.dip2px(20.0F);
                j = j - i - ViewUtils.dip2px(30.0F) * 2;
                i = this.a.getWidth() * j / this.a.getHeight();
                if (i <= k - m * 2) {
                  break label1186;
                }
                i = k - m * 2;
                j = this.a.getHeight() * i / this.a.getWidth();
              }
              for (;;)
              {
                localObject1 = (ImageView)localView.findViewById(2131377552);
                localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = j;
                ((RelativeLayout.LayoutParams)localObject2).width = i;
                ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((ImageView)localObject1).setImageBitmap(this.a);
                return localView;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhhp
 * JD-Core Version:    0.7.0.1
 */