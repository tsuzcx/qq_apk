package com.tencent.biz;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;

public class PoiMapActivity$PoiItemAdapter
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList<PoiMapActivity.POI> a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PoiMapActivity$PoiItemAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PoiMapActivity.POI a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i >= 0)) {
      return (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    }
    return null;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    if (paramInt != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramInt;
      notifyDataSetChanged();
      if ((paramInt != -1) && (paramBoolean))
      {
        PoiMapActivity.POI localPOI = a(paramInt);
        if (localPOI == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.mCurPoiName = localPOI.a;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.mCurPoiAdr = localPOI.jdField_b_of_type_JavaLangString;
        PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.j = localPOI.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.k = localPOI.jdField_c_of_type_Int;
        PoiMapActivity.g(this.jdField_a_of_type_ComTencentBizPoiMapActivity).b();
        TencentMap localTencentMap = PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
        double d1 = localPOI.jdField_b_of_type_Int;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        double d2 = localPOI.jdField_c_of_type_Int;
        Double.isNaN(d2);
        localTencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Int += 1;
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (paramView == null)
    {
      localObject1 = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2131559960, null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377358);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377357));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371709));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362252));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377149);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131371496);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365560);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377356));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379400));
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374731));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    if ((paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) && ((!this.jdField_a_of_type_Boolean) || (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      PoiMapActivity.POI localPOI = a(paramInt);
      if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
      }
      if (localPOI == null)
      {
        localObject1 = localObject2;
        break label578;
      }
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(8);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidViewView.setVisibility(8);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setBackgroundResource(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localPOI.a);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.jdField_b_of_type_JavaLangString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localPOI.a);
      ((StringBuilder)localObject2).append(localPOI.jdField_b_of_type_JavaLangString);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramInt == this.jdField_a_of_type_Int)
      {
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.g);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694943));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
        ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_c_of_type_AndroidViewView.setVisibility(4);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131694944));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramView.setContentDescription((CharSequence)localObject1);
    }
    else
    {
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_d_of_type_AndroidViewView.setVisibility(0);
      ((PoiMapActivity.PoiItemViewHolder)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    Object localObject1 = paramView;
    label578:
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiItemAdapter
 * JD-Core Version:    0.7.0.1
 */