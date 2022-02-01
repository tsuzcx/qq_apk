package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorFilter;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryTroopMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private boolean y;
  private TroopFileError.TroopFileErrorObserver z;
  
  private void F()
  {
    if (this.y)
    {
      this.g.a(1600);
      this.g.a(this, false);
      return;
    }
    this.g.a(l());
    this.g.a(this, true);
  }
  
  private boolean a(FragmentActivity paramFragmentActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFragmentActivity != null)
    {
      if (paramFragmentActivity.getIntent() == null) {
        return false;
      }
      bool1 = bool2;
      if (paramFragmentActivity.getIntent().getIntExtra("uintype", -1) == 10014) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void E()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getBaseActivity(), null);
    localActionSheet.setMainTitle(2131886527);
    localActionSheet.addButton(2131886528, 5);
    int m = C();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.t.size()) {
        break;
      }
      if (((((AIORichMediaInfo)this.t.get(i)).a instanceof AIOImageData)) && (((AIOImageData)((AIORichMediaInfo)this.t.get(i)).a).n == null))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131890811);
    }
    if ((m == 1) && (j == 0)) {
      localActionSheet.addButton(2131890805, 5);
    }
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ChatHistoryTroopMediaFragment.1(this, localActionSheet, (ArrayList)this.t.clone()));
    localActionSheet.show();
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      AIOImageListScene.a(this.d, paramIntent);
    }
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    Object localObject1 = QQUtils.a();
    String str1 = g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("__qzone_pic_permission__");
    ((StringBuilder)localObject2).append(str1);
    if (LocalMultiProcConfig.getInt4Uin(((StringBuilder)localObject2).toString(), -1, Long.valueOf((String)localObject1).longValue()) == 0)
    {
      paramArrayList = new QQCustomDialog(getBaseActivity(), 2131953338);
      paramArrayList.setContentView(2131624611);
      paramArrayList.setTitle(getBaseActivity().getString(2131895447));
      paramArrayList.setMessage(getBaseActivity().getString(2131895445));
      paramArrayList.setNegativeButton(getBaseActivity().getString(2131895446), new ChatHistoryTroopMediaFragment.2(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject1, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.makeText(getBaseActivity(), 2131889677, 0).show();
      return;
    }
    str1 = getBaseActivity().getIntent().getStringExtra("UploadPhoto.key_album_id");
    localObject2 = getBaseActivity().getIntent().getStringExtra("UploadPhoto.key_album_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forwardToGroupAlbum, albumId = ");
      String str2 = "null";
      if (str1 != null) {
        localObject1 = str1;
      } else {
        localObject1 = "null";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" , albumName = ");
      localObject1 = str2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("ChatHistoryMediaBaseFragment", 2, localStringBuilder.toString());
    }
    a(paramArrayList, str1, (String)localObject2);
  }
  
  void a(ArrayList<AIORichMediaInfo> paramArrayList, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (AIORichMediaInfo)paramArrayList.next();
      if (AIOImageData.class.isInstance(((AIORichMediaInfo)localObject).a))
      {
        localObject = (AIOImageData)((AIORichMediaInfo)localObject).a;
        localArrayList1.add(((AIOImageData)localObject).a);
        localArrayList2.add(((AIOImageData)localObject).n);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).o));
      }
    }
    AIOGalleryUtils.a(getBaseActivity(), QQUtils.a(), g(), g(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  void b(ArrayList<AIORichMediaInfo> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    AIOGalleryUtils.a(getBaseActivity(), QQUtils.a(), g(), 0, (List)paramArrayList.clone(), true, g());
  }
  
  public void i()
  {
    super.i();
    F();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.z != null)
    {
      TroopFileError.b(this.a, this.z);
      this.z = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.z != null)
    {
      TroopFileError.b(this.a, this.z);
      this.z = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.z == null)
    {
      Object localObject = g();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new ChatHistoryTroopMediaFragment.TroopFileErrorFilter(this, Long.parseLong((String)localObject));
        this.z = new ChatHistoryTroopMediaFragment.MediaTroopFileErrorObserver(this, this.d, (TroopFileError.TroopFileErrorFilter)localObject, this.a);
      }
    }
    if (this.z != null) {
      TroopFileError.a(this.a, this.z);
    }
  }
  
  protected void v()
  {
    E();
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void w()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void x()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void y()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  void z()
  {
    ReportController.b(this.a, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */