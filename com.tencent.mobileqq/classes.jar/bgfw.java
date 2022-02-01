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

public class bgfw
  extends bgfi
{
  protected String b;
  protected Map<bger, Stream<bger>> b;
  
  public bgfw(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public bgfz a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560623, paramViewGroup, false);
    bgfz localbgfz = new bgfz(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localbgfz.hashCode()) });
    }
    b(localbgfz.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localbgfz);
    b(localbgfz.jdField_a_of_type_AndroidWidgetImageView, localbgfz);
    b(localbgfz.b, localbgfz);
    b(localbgfz.c, localbgfz);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localbgfz;
  }
  
  protected SimpleObserver<bgel> a(bgel parambgel)
  {
    return new bgfx(this, parambgel);
  }
  
  protected SimpleObserver<bger> a(bger parambger)
  {
    return new bgfy(this, parambger);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bger)localIterator.next();
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
        localObject = (bger)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((bger)localObject).c), ", type=", Integer.valueOf(((bger)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((bger)localObject).d;
      ((bger)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((bger)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, bgfm parambgfm)
  {
    bger localbger = (bger)parambgfm.jdField_a_of_type_Bgeg;
    switch (paramView.getId())
    {
    case 2131368094: 
    default: 
    case 2131368091: 
    case 2131368095: 
      do
      {
        return;
        this.jdField_a_of_type_Bgfd.a(parambgfm);
        return;
      } while (localbger.g != 2);
      parambgfm.b.setVisibility(4);
      a(localbger);
      return;
    }
    blgx.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localbger.c), ", path=", localbger.f });
    }
    a(localbger);
  }
  
  protected void a(bgel parambgel)
  {
    parambgel = (bger)parambgel;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = parambgel.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(parambgel))) {
      this.jdField_b_of_type_JavaUtilMap.put(parambgel, localStream1);
    }
    Stream localStream2 = parambgel.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(parambgel)) {
      this.jdField_a_of_type_JavaUtilMap.put(parambgel, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = parambgel.d;
        parambgel.a = System.currentTimeMillis();
        localStream1.subscribe(a(parambgel));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = parambgel.d;
    this.jdField_a_of_type_Boolean = true;
    parambgel.a = System.currentTimeMillis();
    localStream2.subscribe(a(parambgel));
  }
  
  public void a(bger parambger)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", parambger.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    parambger = new Intent();
    parambger.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    parambger.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(parambger);
  }
  
  protected void a(bgfm parambgfm, bgel parambgel, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      parambgfm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      parambgfm.c.setVisibility(0);
      parambgfm.b.setVisibility(4);
      parambgfm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      parambgfm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (parambgel.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        parambgfm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        parambgfm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        parambgfm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(parambgel.e, parambgel.d);
        parambgfm.b.setVisibility(4);
        parambgfm.c.setVisibility(4);
        return;
      }
    } while (parambgel.e != 100);
    parambgfm.a();
    return;
    parambgfm.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    parambgfm.b.setVisibility(0);
    parambgfm.c.setVisibility(4);
  }
  
  public void d(bgeg parambgeg)
  {
    super.d(parambgeg);
    parambgeg = (bger)parambgeg;
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      parambgeg = (Stream)this.jdField_b_of_type_JavaUtilMap.get(parambgeg);
      if (parambgeg != null) {
        parambgeg.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfw
 * JD-Core Version:    0.7.0.1
 */