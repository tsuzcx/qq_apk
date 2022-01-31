import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class bacw
  extends baci
{
  protected String b;
  protected Map<babr, Stream<babr>> b;
  
  public bacw(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bacz a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560346, paramViewGroup, false);
    bacz localbacz = new bacz(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbacz.hashCode()) });
    }
    b(localbacz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbacz);
    b(localbacz.jdField_a_of_type_AndroidWidgetImageView, localbacz);
    b(localbacz.b, localbacz);
    b(localbacz.c, localbacz);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbacz;
  }
  
  protected SimpleObserver<babl> a(babl parambabl)
  {
    return new bacx(this, parambabl);
  }
  
  protected SimpleObserver<babr> a(babr parambabr)
  {
    return new bacy(this, parambabr);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (babr)localIterator.next();
        localObject = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      super.a(paramInt, paramBoolean);
    }
    do
    {
      Object localObject;
      Stream localStream;
      do
      {
        do
        {
          return;
        } while (paramInt != 1);
        localObject = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
        }
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localObject = (babr)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((babr)localObject).c), ", type=", Integer.valueOf(((babr)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((babr)localObject).d;
      ((babr)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((babr)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bacm parambacm)
  {
    babr localbabr = (babr)parambacm.jdField_a_of_type_Babg;
    switch (paramView.getId())
    {
    case 2131367571: 
    default: 
    case 2131367568: 
    case 2131367572: 
      do
      {
        return;
        this.jdField_a_of_type_Bacd.a(parambacm);
        return;
      } while (localbabr.g != 2);
      parambacm.b.setVisibility(4);
      a(localbabr);
      return;
    }
    bfni.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbabr.c), ", path=", localbabr.f });
    }
    a(localbabr);
  }
  
  protected void a(babl parambabl)
  {
    parambabl = (babr)parambabl;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambabl.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambabl))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambabl, localStream1);
    }
    Stream localStream2 = parambabl.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambabl)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambabl, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambabl.d;
        parambabl.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambabl));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambabl.d;
    this.jdField_a_of_type_Boolean = true;
    parambabl.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambabl));
  }
  
  public void a(babr parambabr)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambabr.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambabr = new Intent();
    parambabr.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambabr.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambabr);
  }
  
  protected void a(bacm parambacm, babl parambabl, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambacm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambacm.c.setVisibility(0);
      parambacm.b.setVisibility(4);
      parambacm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambacm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambabl.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambacm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambacm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambacm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambabl.e, parambabl.d);
        parambacm.b.setVisibility(4);
        parambacm.c.setVisibility(4);
        return;
      }
    } while (parambabl.e != 100);
    parambacm.a();
    return;
    parambacm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambacm.b.setVisibility(0);
    parambacm.c.setVisibility(4);
  }
  
  public void d(babg parambabg)
  {
    super.d(parambabg);
    parambabg = (babr)parambabg;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambabg = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambabg);
      if (parambabg != null) {
        parambabg.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacw
 * JD-Core Version:    0.7.0.1
 */