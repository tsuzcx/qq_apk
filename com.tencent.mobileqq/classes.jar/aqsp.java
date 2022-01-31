import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FullPopData;
import com.tencent.mobileqq.gamecenter.view.FullPopVideoView;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aqsp
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aqri jdField_a_of_type_Aqri;
  private FullPopData jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData;
  private FullPopVideoView jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private ImageView c;
  public boolean c;
  private ImageView d;
  
  public aqsp(Context paramContext, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = aqst.a(paramMessageRecord);
    this.jdField_b_of_type_JavaLangString = aqst.a(paramMessageRecord, 0);
    a();
  }
  
  public aqsp(Context paramContext, QQGameMsgInfo paramQQGameMsgInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramQQGameMsgInfo.paMsgid;
    this.jdField_b_of_type_JavaLangString = paramQQGameMsgInfo.gameAppId;
    a();
  }
  
  public static Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (apvb.b(paramString1)) {
      return aqss.a(paramString1 + "/" + paramString2, paramInt1, paramInt2);
    }
    return null;
  }
  
  public static File a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1 + "/" + paramString2);
    if (paramString1.exists()) {
      return paramString1;
    }
    return null;
  }
  
  private void a()
  {
    Object localObject1 = aqsu.a();
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject1 = new StringBuffer();
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          ((StringBuffer)localObject1).append(" " + str);
        }
        QLog.d("FullPopBussiness", 1, "<getFullPopIdList>  fullPopIdsb=" + ((StringBuffer)localObject1).toString());
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      return;
    }
    QLog.d("FullPopBussiness", 1, "<getFullPopIdList>  fullPopIdList is null");
  }
  
  private void a(String paramString)
  {
    String str = aqsu.a();
    if (!TextUtils.isEmpty(str)) {
      aqsu.a(str + paramString + "-");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FullPopBussiness", 1, "<saveFullPopIdList>  id=" + paramString);
      }
      return;
      aqsu.a(paramString + "-");
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      HashMap localHashMap = new HashMap();
      yod.a(localHashMap, paramString1);
      localHashMap.put(Integer.valueOf(1), paramString2);
      localHashMap.put(Integer.valueOf(2), paramString1);
      if (paramBoolean) {
        localHashMap.put(Integer.valueOf(24), Integer.valueOf(1));
      }
      yod.a(ajae.a(), "769", paramString3, paramString2, "76906", "1", "160", localHashMap);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366865));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366866));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366863));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366867));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366864));
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView = ((FullPopVideoView)paramView.findViewById(2131379000));
    this.d = ((ImageView)paramView.findViewById(2131367963));
  }
  
  public void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, QQGameMsgInfo paramQQGameMsgInfo)
  {
    if (((paramQQGameMsgInfo == null) && (paramMessageRecord == null)) || (paramAppInterface == null)) {}
    label319:
    for (;;)
    {
      return;
      int i = aqss.b();
      if ((i != 1) && (i != 4) && (i != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FullPopBussiness", 1, "currentType is:" + i);
        }
      }
      else
      {
        long l1 = aqsu.a();
        long l2 = aqss.a() * 24 * 60 * 60 * 1000;
        long l3 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          QLog.d("FullPopBussiness", 1, "lastFullPopExtTime is:" + l1);
          QLog.d("FullPopBussiness", 1, "fullPopInterval is:" + l2);
          QLog.d("FullPopBussiness", 1, "nowTime is:" + l3);
        }
        if (l1 > l3)
        {
          aqsu.a(0L);
          return;
        }
        if ((l1 < 0L) || (l2 < 0L) || (l3 - l1 <= l2)) {
          break label355;
        }
        Object localObject = null;
        if (paramMessageRecord != null) {
          paramMessageRecord = aqsu.a(paramMessageRecord);
        }
        for (;;)
        {
          if (paramMessageRecord == null) {
            break label319;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FullPopBussiness", 1, "<checkFullPopRes> fullPopData.id:" + paramMessageRecord.id);
          }
          if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageRecord.id)) {
            break label321;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FullPopBussiness", 1, "the full pop is already played.");
          return;
          paramMessageRecord = localObject;
          if (paramQQGameMsgInfo != null) {
            paramMessageRecord = paramQQGameMsgInfo.fullPopData;
          }
        }
      }
    }
    label321:
    if (QLog.isColorLevel()) {
      QLog.d("FullPopBussiness", 1, "the full pop is not played.");
    }
    aqsu.a(paramAppInterface, paramMessageRecord.resUrl, new aqsq(this, paramMessageRecord), false);
    return;
    label355:
    if (QLog.isColorLevel()) {
      QLog.d("FullPopBussiness", 1, "full pop is lose efficacy because time");
    }
    a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "205930", true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext)) {
      if (a())
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label158;
        }
        this.jdField_a_of_type_Aqri = new aqrd(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramBoolean);
        this.jdField_a_of_type_Aqri.a(new View[] { this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqGamecenterViewFullPopVideoView, this.d });
        this.jdField_a_of_type_Aqri.b();
        this.jdField_b_of_type_Boolean = true;
        a(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData.id);
        a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "205926", paramBoolean);
      }
    }
    label158:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Aqri = new aqqw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramBoolean);
      }
    }
    QLog.d("FullPopBussiness", 1, "TVK_SDKMgr is not isInstalled");
  }
  
  public boolean a()
  {
    return (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataFullPopData != null) && (this.jdField_c_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsp
 * JD-Core Version:    0.7.0.1
 */