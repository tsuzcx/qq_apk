package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ZimuLiveManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.HashMap;

public class ZimuViewLiveAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ZimuLiveManager jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public ZimuViewLiveAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager = ((ZimuLiveManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(9));
    int j = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.a.size();
    int i;
    if (j > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        ZimuViewLiveAdapter.ZimuViewLiveAdapterItem localZimuViewLiveAdapterItem = (ZimuViewLiveAdapter.ZimuViewLiveAdapterItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.a.get(i);
        if (!localZimuViewLiveAdapterItem.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaLangString = localZimuViewLiveAdapterItem.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.jdField_a_of_type_JavaLangString;
        }
      }
      else
      {
        this.jdField_a_of_type_Int = (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() * 32 / 750);
        return;
      }
      i += 1;
    }
  }
  
  private BitmapDrawable a(String paramString)
  {
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject = localBitmapDrawable;
    if (localBitmapDrawable == null)
    {
      localObject = (VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), ((VideoAppInterface)localObject).a(0, paramString, null, true, true));
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    return localObject;
  }
  
  private View a(LayoutInflater paramLayoutInflater, int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = paramLayoutInflater.inflate(paramInt2, paramViewGroup, false);
    }
    paramLayoutInflater = a(paramInt1);
    paramView = localView.findViewById(2131363068);
    paramViewGroup = (TextView)localView.findViewById(2131363651);
    paramViewGroup.setTextSize(0, this.jdField_a_of_type_Int);
    if (paramLayoutInflater.jdField_a_of_type_Boolean)
    {
      paramView.setVisibility(8);
      paramViewGroup.setPadding(0, 0, 0, 0);
      paramViewGroup.setText(paramLayoutInflater.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.jdField_a_of_type_JavaLangCharSequence);
      if ((paramLayoutInflater.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramLayoutInflater.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.jdField_a_of_type_JavaLangString))) {
        break label183;
      }
    }
    label183:
    for (paramInt1 = -9447169;; paramInt1 = -1)
    {
      paramViewGroup.setTextColor(paramInt1);
      paramViewGroup.setSpannableFactory(QQText.a);
      return localView;
      paramView.setVisibility(0);
      paramView.setBackgroundDrawable(a(paramLayoutInflater.jdField_a_of_type_ComTencentAvBusinessHandlerSentenceInfo.jdField_a_of_type_JavaLangString));
      paramViewGroup.setPadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0, 0);
      break;
    }
  }
  
  public ZimuViewLiveAdapter.ZimuViewLiveAdapterItem a(int paramInt)
  {
    return (ZimuViewLiveAdapter.ZimuViewLiveAdapterItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.a.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(SentenceInfo paramSentenceInfo, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.a(paramSentenceInfo, paramBoolean)) && (this.jdField_a_of_type_JavaLangString == null) && (!paramBoolean)) {
      this.jdField_a_of_type_JavaLangString = paramSentenceInfo.jdField_a_of_type_JavaLangString;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerZimuZimuLiveManager.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(this.jdField_a_of_type_AndroidViewLayoutInflater, paramInt, paramView, paramViewGroup, 2130969281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewLiveAdapter
 * JD-Core Version:    0.7.0.1
 */