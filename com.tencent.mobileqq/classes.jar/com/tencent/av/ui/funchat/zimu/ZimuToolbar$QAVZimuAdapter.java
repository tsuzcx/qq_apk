package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class ZimuToolbar$QAVZimuAdapter
  extends QAVPtvTemplateAdapter
{
  WeakReference<ZimuToolbar> a;
  
  public ZimuToolbar$QAVZimuAdapter(AppInterface paramAppInterface, Context paramContext, ArrayList<QavListItemBase.ItemInfo> paramArrayList, HorizontalListView paramHorizontalListView, ZimuToolbar paramZimuToolbar)
  {
    super(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView);
    this.a = new WeakReference(paramZimuToolbar);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      j = getCount();
      i = 1;
      while (i < j)
      {
        localObject = a(i);
        if ((localObject != null) && (paramString2.equals(((QavListItemBase.ItemInfo)localObject).a)))
        {
          bool1 = true;
          break label71;
        }
        i += 1;
      }
    }
    boolean bool1 = false;
    int i = 1;
    label71:
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSelectedItem, id[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], find[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], mCurSelectedPosition[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]");
      QLog.w("QAVPtvTemplateAdapter", 1, ((StringBuilder)localObject).toString());
    }
    int j = this.d;
    boolean bool2 = a(i);
    if (bool2) {
      a(paramLong, this.d);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectedItem end, from[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], id[");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("], find[");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append("], index[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("], Pos[");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("->");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("], selectResult[");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append("]");
    QLog.w("QAVPtvTemplateAdapter", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar.QAVZimuAdapter
 * JD-Core Version:    0.7.0.1
 */