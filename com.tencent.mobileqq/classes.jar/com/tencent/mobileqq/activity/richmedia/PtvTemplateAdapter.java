package com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.LbsUpdateFilter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.Iterator;
import xzd;
import xze;
import xzf;
import xzi;

public class PtvTemplateAdapter
  extends BaseAdapter
  implements LbsFilterStatusManager.LbsUpdateFilter
{
  float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback = new xze(this);
  private PtvTemplateAdapter.IPtvTemplateItemChangedCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemChangedCallback;
  private PtvTemplateAdapter.IPtvTemplateItemSelectedCallback jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemSelectedCallback;
  public FSurfaceViewLayout a;
  private PtvTemplateManager.IPtvTemplateDownloadListener jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener = new xzf(this);
  public PtvTemplateManager.PtvTemplateInfo a;
  PtvTemplateManager jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager;
  HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new xzi(this);
  public HorizontalListView a;
  public String a;
  public ArrayList a;
  public int b;
  public PtvTemplateManager.PtvTemplateInfo b;
  public int c;
  
  public PtvTemplateAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList paramArrayList, int paramInt, HorizontalListView paramHorizontalListView, FSurfaceViewLayout paramFSurfaceViewLayout)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new xzd(this));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = c();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = paramFSurfaceViewLayout;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager = PtvTemplateManager.a(paramAppInterface);
    this.c = paramInt;
    a(paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
    LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + this.c;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a()
  {
    int i = a();
    Object localObject;
    if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      localObject = null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      return localObject;
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localObject = localPtvTemplateInfo;
    } while (localPtvTemplateInfo != null);
    return null;
  }
  
  public PtvTemplateManager.PtvTemplateInfo a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    return (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public String a()
  {
    int i = a();
    if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if (localPtvTemplateInfo == null) {
      return null;
    }
    if ((TextUtils.isEmpty(localPtvTemplateInfo.id)) || (localPtvTemplateInfo.id.equals("0")) || (localPtvTemplateInfo.id.equals("-1")) || (localPtvTemplateInfo.id.equals("-2"))) {
      return null;
    }
    return localPtvTemplateInfo.id;
  }
  
  public void a()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if ((!StringUtil.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null))
    {
      localPtvTemplateInfo = a();
      if ((localPtvTemplateInfo != null) && ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.category != 0))) {
        break label83;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "setCurrentFilter:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
      label83:
      if (localPtvTemplateInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_JavaLangString, localPtvTemplateInfo.category, localPtvTemplateInfo.gestureType, localPtvTemplateInfo.gestureWording);
      }
    }
  }
  
  public void a(PtvTemplateAdapter.IPtvTemplateItemChangedCallback paramIPtvTemplateItemChangedCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemChangedCallback = paramIPtvTemplateItemChangedCallback;
  }
  
  public void a(PtvTemplateAdapter.IPtvTemplateItemSelectedCallback paramIPtvTemplateItemSelectedCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemSelectedCallback = paramIPtvTemplateItemSelectedCallback;
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo != null) {}
    for (;;)
    {
      this.b = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = paramPtvTemplateInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemSelectedCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemSelectedCallback.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.type);
      }
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id.equals("0"))) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter("");
        this.jdField_a_of_type_JavaLangString = "";
        if (QLog.isColorLevel()) {
          QLog.i("PtvTemplateManager", 2, "setVideoFilter null");
        }
      }
      int i;
      do
      {
        return;
        i = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + this.c;
      } while (i >= this.jdField_a_of_type_JavaUtilArrayList.size());
      paramPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    }
    LbsFilterStatusManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable)
    {
      paramPtvTemplateInfo = PtvTemplateManager.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PtvTemplateManager", 2, "setVideoFilter " + paramPtvTemplateInfo + " type is " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.type);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.category == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(paramPtvTemplateInfo);
          label266:
          this.jdField_a_of_type_JavaLangString = paramPtvTemplateInfo;
        }
      }
      else
      {
        label271:
        if (FlowCameraConstant.jdField_a_of_type_Int != 2) {
          break label469;
        }
      }
    }
    label469:
    for (paramPtvTemplateInfo = "0";; paramPtvTemplateInfo = "1")
    {
      FlowCameraMqqAction.a("", "0X80075BA", paramPtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, "", "");
      if (!this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.hasGesture()) {
        break;
      }
      FlowCameraMqqAction.a("", "0X80083AE", paramPtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id, "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(paramPtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.category, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureType, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureWording);
      if (!QLog.isColorLevel()) {
        break label266;
      }
      QLog.i("PtvTemplateManager", 2, "setVideoFilter gestureWording is " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.gestureWording);
      break label266;
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) || (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager == null)) {
        break label271;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
      ShortVideoMtaReport.a("shortvideo_download_effects", null);
      break label271;
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains(paramString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_JavaLangString);
      return;
    }
    LbsFilterStatusManager.a("lbsUpdateFilter", String.format("currentPath=%s,name=%s", new Object[] { "" + this.jdField_a_of_type_JavaLangString, "" + paramString }), null);
  }
  
  public void a(ArrayList paramArrayList)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
      localPtvTemplateInfo.id = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
      int i = 0;
      while (i < this.c)
      {
        localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
        localPtvTemplateInfo.id = "0";
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
        i += 1;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramArrayList.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localPtvTemplateInfo);
      }
      paramArrayList = new PtvTemplateManager.PtvTemplateInfo();
    }
    finally {}
    paramArrayList.id = "-2";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
    paramArrayList = new PtvTemplateManager.PtvTemplateInfo();
    paramArrayList.id = "-1";
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList);
  }
  
  public int b()
  {
    int i = a();
    if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return 0;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if (localPtvTemplateInfo == null) {
      return 0;
    }
    return localPtvTemplateInfo.type;
  }
  
  public String b()
  {
    int i = a();
    if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return null;
    }
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
    if (localPtvTemplateInfo == null) {
      return null;
    }
    return localPtvTemplateInfo.name;
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels / 4.5F);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a(paramInt);
    if ("-1".equals(paramViewGroup.id))
    {
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams((int)(this.jdField_a_of_type_Int * 0.75F), this.jdField_a_of_type_Int));
      return paramView;
    }
    if ("-2".equals(paramViewGroup.id))
    {
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      return paramView;
    }
    if ((paramView == null) || (!(paramView instanceof PtvTemplateItemView)))
    {
      paramView = new PtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      paramView.a(paramInt, (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter$IPtvTemplateItemCallback);
      return paramView;
      paramView = (PtvTemplateItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */