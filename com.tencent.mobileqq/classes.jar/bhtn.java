import QC.CGetChiefRsp;
import QC.ItemDisDetail;
import QC.ModuleData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class bhtn
  extends RecyclerView.Adapter<bhtp>
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhtq jdField_a_of_type_Bhtq;
  private bhtr jdField_a_of_type_Bhtr;
  private bhtw jdField_a_of_type_Bhtw;
  private ArrayList<bhtr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private bhtr b;
  
  public bhtn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130847467;
    case 0: 
    case 1: 
      return 2130847466;
    case 4: 
      return 2130847471;
    case 5: 
      return 2130847470;
    case 21: 
      return 2130847469;
    }
    return 2130847468;
  }
  
  private Drawable a(String paramString, boolean paramBoolean)
  {
    int i = 14606046;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.contains("#")) {
        str = "#" + paramString;
      }
      i = Color.parseColor(str);
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847480) });
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a(paramInt), 0);
  }
  
  private void a(bhtp parambhtp, int paramInt, bhtr parambhtr)
  {
    parambhtp.jdField_a_of_type_AndroidWidgetTextView.setText(parambhtr.jdField_a_of_type_JavaLangString);
    if (parambhtp.b != null) {
      parambhtp.b.setText(parambhtr.jdField_b_of_type_JavaLangString);
    }
    View localView = parambhtp.itemView.findViewById(2131378209);
    if (localView != null)
    {
      if (TextUtils.isEmpty(parambhtr.jdField_b_of_type_JavaLangString)) {
        localView.setVisibility(8);
      }
    }
    else
    {
      parambhtr = parambhtp.itemView.findViewById(2131365754);
      if (parambhtr != null)
      {
        if (paramInt <= 1) {
          break label134;
        }
        parambhtr.setVisibility(0);
      }
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 21) {
        parambhtp.c.getBackground().setTint(Color.parseColor("#FFDE66"));
      }
      parambhtp.c.setOnClickListener(new bhto(this));
      return;
      localView.setVisibility(0);
      break;
      label134:
      parambhtr.setVisibility(8);
    }
  }
  
  private void a(bhtr parambhtr)
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Bhtw != null) {
      this.jdField_a_of_type_Bhtw.a(parambhtr.jdField_c_of_type_Int, parambhtr.jdField_b_of_type_Int);
    }
  }
  
  public bhtp a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 1: 
      return new bhtp(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562082, null));
    }
    paramViewGroup = new bhtp(this, View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562084, null));
    paramViewGroup.jdField_a_of_type_Boolean = true;
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if ((((bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a()) && (((bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int == paramInt))
        {
          this.jdField_a_of_type_Int = paramInt;
          this.jdField_a_of_type_Bhtr = ((bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(bhtp parambhtp, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)) {}
    bhtr localbhtr;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onRecyclerBindViewHolder(parambhtp, paramInt, getItemId(paramInt));
        return;
        localbhtr = (bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        if (localbhtr.jdField_a_of_type_Int != 2) {
          break;
        }
        a(parambhtp, paramInt, localbhtr);
      }
    } while (!((bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
    parambhtp.jdField_a_of_type_AndroidWidgetTextView.setText(localbhtr.e);
    boolean bool;
    if (this.jdField_a_of_type_Int == localbhtr.jdField_b_of_type_Int)
    {
      bool = true;
      label109:
      parambhtp.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(localbhtr.jdField_d_of_type_JavaLangString, bool));
      if (localbhtr.jdField_a_of_type_Boolean)
      {
        parambhtp.jdField_a_of_type_AndroidWidgetButton.setText(2131691803);
        parambhtp.jdField_a_of_type_AndroidWidgetButton.setTextColor(parambhtp.jdField_a_of_type_AndroidWidgetButton.getResources().getColor(2131165501));
      }
      int i = (ScreenUtil.getRealWidth(this.jdField_a_of_type_AndroidContentContext) - ScreenUtil.dip2px(96.0F)) / 3;
      ViewGroup.LayoutParams localLayoutParams = parambhtp.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = ((int)(i * 0.57F));
      parambhtp.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      parambhtp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(bhoo.a(localbhtr.jdField_c_of_type_JavaLangString));
      a(parambhtp.jdField_a_of_type_AndroidWidgetTextView, localbhtr.jdField_d_of_type_Int);
      if (localbhtr.jdField_a_of_type_Boolean) {
        break label299;
      }
      parambhtp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bhts(this, localbhtr, true));
    }
    for (;;)
    {
      parambhtp.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setOnClickListener(new bhts(this, localbhtr, false));
      break;
      bool = false;
      break label109;
      label299:
      parambhtp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(null);
    }
  }
  
  public void a(bhtq parambhtq)
  {
    this.jdField_a_of_type_Bhtq = parambhtq;
  }
  
  public void a(bhtw parambhtw)
  {
    this.jdField_a_of_type_Bhtw = parambhtw;
  }
  
  @UiThread
  public void a(Object[] paramArrayOfObject)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramArrayOfObject == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if ((localObject instanceof CGetChiefRsp))
      {
        localObject = (CGetChiefRsp)localObject;
        if ((((CGetChiefRsp)localObject).ret == 0) && (((CGetChiefRsp)localObject).modData != null) && (((CGetChiefRsp)localObject).modData.size() > 0))
        {
          Iterator localIterator1 = ((CGetChiefRsp)localObject).modData.iterator();
          while (localIterator1.hasNext())
          {
            ModuleData localModuleData = (ModuleData)localIterator1.next();
            localObject = "";
            if (localModuleData.extModParams != null) {
              localObject = (String)localModuleData.extModParams.get("subTitle");
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(new bhtr(this, 2, localModuleData.cname, (String)localObject));
            if (this.jdField_a_of_type_Boolean) {
              bhtm.a(2, 0, 0, 111);
            }
            if ((localModuleData.vitem != null) && (localModuleData.vitem.size() != 0))
            {
              Iterator localIterator2 = localModuleData.vitem.iterator();
              while (localIterator2.hasNext())
              {
                ItemDisDetail localItemDisDetail = (ItemDisDetail)localIterator2.next();
                this.jdField_a_of_type_JavaUtilArrayList.add(new bhtr(this, 0, localModuleData.cname, (String)localObject, localItemDisDetail));
                if (this.jdField_a_of_type_Boolean) {
                  bhtm.a(2, localItemDisDetail.itemId, localItemDisDetail.feeType, 101);
                }
              }
              this.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((bhtr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtn
 * JD-Core Version:    0.7.0.1
 */