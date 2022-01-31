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
import com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbjl
  extends bbjc
{
  protected Bitmap a;
  
  public bbjl(Context paramContext)
  {
    super(paramContext, false);
  }
  
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562426, null);
    this.jdField_a_of_type_Bbji.a((RelativeLayout)localView.findViewById(2131362137));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361919));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375662));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375663));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label390;
      }
      localObject1 = localObject2[0];
      label122:
      if (!((List)localObject1).isEmpty()) {
        break label1200;
      }
    }
    label147:
    label1183:
    label1189:
    label1192:
    label1195:
    label1200:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label1195;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298815));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject1), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.e, a((List)localObject2), 5), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296668);
        int i;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367168));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label350:
          if (((Iterator)localObject4).hasNext())
          {
            if (((bbje)((Iterator)localObject4).next()).d != 0) {
              break label1192;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label350;
          f();
          break;
          localObject1 = new ArrayList(0);
          break label122;
          localObject2 = new ArrayList(0);
          break label147;
          int n = this.d + a() + this.d;
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(n);
          this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
          localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.h + this.h);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.c + this.f + ((StaticLayout)localObject3).getHeight() + m);
          this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new bbjf(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367169));
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((bbje)((Iterator)localObject1).next()).d != 0) {
                break label1189;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.d + a() + this.d;
            this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(n);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
            this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.h + this.h);
            this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.c + this.f + ((StaticLayout)localObject3).getHeight() + m);
            this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new bbjf(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
            this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            localObject1 = (TextView)localView.findViewById(2131361912);
            ((TextView)localObject1).setText(2131690596);
            ((TextView)localObject1).setOnClickListener(new bbjm(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new ShareWithPictureActionSheetBuilder.2(this));
            j = bbkx.a(90.0F);
            i = j;
            if (this.jdField_a_of_type_AndroidWidgetGridView != null) {
              i = j + this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().height;
            }
            if (this.jdField_b_of_type_AndroidWidgetGridView != null) {
              i += this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams().height;
            }
            for (;;)
            {
              k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
              j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
              localObject1 = (RelativeLayout)localView.findViewById(2131376022);
              localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = (j - i);
              ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
              {
                m = bbkx.a(20.0F);
                j = j - i - bbkx.a(30.0F) * 2;
                i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * j / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
                if (i <= k - m * 2) {
                  break label1183;
                }
                i = k - m * 2;
                j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * i / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
              }
              for (;;)
              {
                localObject1 = (ImageView)localView.findViewById(2131376021);
                localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = j;
                ((RelativeLayout.LayoutParams)localObject2).width = i;
                ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                ((ImageView)localObject1).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
                return localView;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjl
 * JD-Core Version:    0.7.0.1
 */