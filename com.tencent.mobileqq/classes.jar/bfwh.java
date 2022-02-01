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

public class bfwh
  extends bfvt
{
  protected String b;
  protected Map<bfvc, Stream<bfvc>> b;
  
  public bfwh(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bfwk a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560686, paramViewGroup, false);
    bfwk localbfwk = new bfwk(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbfwk.hashCode()) });
    }
    b(localbfwk.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbfwk);
    b(localbfwk.jdField_a_of_type_AndroidWidgetImageView, localbfwk);
    b(localbfwk.b, localbfwk);
    b(localbfwk.c, localbfwk);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbfwk;
  }
  
  protected SimpleObserver<bfuw> a(bfuw parambfuw)
  {
    return new bfwi(this, parambfuw);
  }
  
  protected SimpleObserver<bfvc> a(bfvc parambfvc)
  {
    return new bfwj(this, parambfvc);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bfvc)localIterator.next();
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
        localObject = (bfvc)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((bfvc)localObject).c), ", type=", Integer.valueOf(((bfvc)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((bfvc)localObject).d;
      ((bfvc)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((bfvc)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bfvx parambfvx)
  {
    bfvc localbfvc = (bfvc)parambfvx.jdField_a_of_type_Bfur;
    switch (paramView.getId())
    {
    case 2131368268: 
    default: 
    case 2131368265: 
    case 2131368269: 
      do
      {
        return;
        this.jdField_a_of_type_Bfvo.a(parambfvx);
        return;
      } while (localbfvc.g != 2);
      parambfvx.b.setVisibility(4);
      a(localbfvc);
      return;
    }
    bkxz.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbfvc.c), ", path=", localbfvc.f });
    }
    a(localbfvc);
  }
  
  protected void a(bfuw parambfuw)
  {
    parambfuw = (bfvc)parambfuw;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambfuw.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambfuw))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambfuw, localStream1);
    }
    Stream localStream2 = parambfuw.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambfuw)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambfuw, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambfuw.d;
        parambfuw.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambfuw));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambfuw.d;
    this.jdField_a_of_type_Boolean = true;
    parambfuw.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambfuw));
  }
  
  public void a(bfvc parambfvc)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambfvc.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambfvc = new Intent();
    parambfvc.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambfvc.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambfvc);
  }
  
  protected void a(bfvx parambfvx, bfuw parambfuw, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambfvx.c.setVisibility(0);
      parambfvx.b.setVisibility(4);
      parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambfvx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambfuw.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambfuw.e, parambfuw.d);
        parambfvx.b.setVisibility(4);
        parambfvx.c.setVisibility(4);
        return;
      }
    } while (parambfuw.e != 100);
    parambfvx.a();
    return;
    parambfvx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambfvx.b.setVisibility(0);
    parambfvx.c.setVisibility(4);
  }
  
  public void d(bfur parambfur)
  {
    super.d(parambfur);
    parambfur = (bfvc)parambfur;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambfur = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambfur);
      if (parambfur != null) {
        parambfur.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwh
 * JD-Core Version:    0.7.0.1
 */