import android.os.Bundle;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mqq.util.WeakReference;

final class amih
  extends anvi
{
  WeakReference<amia> a;
  
  amih(amia paramamia)
  {
    this.a = new WeakReference(paramamia);
  }
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    amia localamia;
    if (paramBoolean)
    {
      localamia = (amia)this.a.get();
      if (localamia == null) {
        break label71;
      }
      paramString = amia.a(localamia, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowAdapter", 2, "onCancelMayKnowRecommend target：" + paramString);
      }
      if (paramString != null) {
        amia.a(localamia, paramString);
      }
    }
    else
    {
      return;
    }
    amia.a(localamia);
    return;
    label71:
    QLog.d("MayKnowAdapter", 1, "onCancelMayKnowRecommend  adapter is null!");
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (amia)this.a.get();
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onGetMayKnowRecommend ");
        }
        amia.a(paramBundle);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onGetMayKnowRecommend adapter is null!");
  }
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList)
  {
    super.onMayKnowListPushAdd(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushAdd");
    }
    if (paramBoolean)
    {
      paramList = (amia)this.a.get();
      if (paramList != null) {
        amia.a(paramList);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onMayKnowListPushAdd adapter is null!");
  }
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList)
  {
    super.onMayKnowListPushDel(paramBoolean, paramList);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "onMayKnowListPushDel");
    }
    if (paramBoolean)
    {
      paramList = (amia)this.a.get();
      if (paramList != null) {
        amia.a(paramList);
      }
    }
    else
    {
      return;
    }
    QLog.d("MayKnowAdapter", 1, "onMayKnowListPushDel adapter is null!");
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      amia localamia = (amia)this.a.get();
      if (localamia == null) {
        break label60;
      }
      if (amia.a(localamia) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MayKnowAdapter", 2, "onMayknowStateChanged");
        }
        localamia.notifyDataSetChanged();
        amia.a(localamia).postDelayed(localamia.a, 1600L);
      }
    }
    return;
    label60:
    QLog.d("MayKnowAdapter", 1, "onMayknowStateChanged adapter is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amih
 * JD-Core Version:    0.7.0.1
 */