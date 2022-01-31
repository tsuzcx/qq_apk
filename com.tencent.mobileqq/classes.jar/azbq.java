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

public class azbq
  extends azbc
{
  protected String b;
  protected Map<azal, Stream<azal>> b;
  
  public azbq(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public azbt a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494774, paramViewGroup, false);
    azbt localazbt = new azbt(paramViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "Video onCreateViewHolder. vh hash=", Integer.valueOf(localazbt.hashCode()) });
    }
    b(localazbt.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, localazbt);
    b(localazbt.jdField_a_of_type_AndroidWidgetImageView, localazbt);
    b(localazbt.b, localazbt);
    b(localazbt.c, localazbt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return localazbt;
  }
  
  protected SimpleObserver<azaf> a(azaf paramazaf)
  {
    return new azbr(this, paramazaf);
  }
  
  protected SimpleObserver<azal> a(azal paramazal)
  {
    return new azbs(this, paramazal);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_JavaUtilMap != null) && (!this.jdField_b_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (azal)localIterator.next();
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
        localObject = (azal)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. next info position=", Integer.valueOf(((azal)localObject).c), ", type=", Integer.valueOf(((azal)localObject).b()), ", hash=", Integer.valueOf(localObject.hashCode()) });
        }
        localStream = (Stream)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      } while (localStream == null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(localObject.hashCode()) });
      }
      this.jdField_b_of_type_JavaLangString = ((azal)localObject).d;
      ((azal)localObject).a = System.currentTimeMillis();
      localStream.subscribe(a((azal)localObject));
      return;
      this.jdField_b_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("VideoItem", 2, new Object[] { "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      }
    } while (this.jdField_a_of_type_Boolean);
    a(0, true);
  }
  
  public void a(View paramView, azbg paramazbg)
  {
    azal localazal = (azal)paramazbg.jdField_a_of_type_Azaa;
    switch (paramView.getId())
    {
    case 2131301954: 
    default: 
    case 2131301951: 
    case 2131301955: 
      do
      {
        return;
        this.jdField_a_of_type_Azax.a(paramazbg);
        return;
      } while (localazal.g != 2);
      paramazbg.b.setVisibility(4);
      a(localazal);
      return;
    }
    beex.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localazal.c), ", path=", localazal.f });
    }
    a(localazal);
  }
  
  protected void a(azaf paramazaf)
  {
    paramazaf = (azal)paramazaf;
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream1 = paramazaf.b(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if ((localStream1 != null) && (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramazaf))) {
      this.jdField_b_of_type_JavaUtilMap.put(paramazaf, localStream1);
    }
    Stream localStream2 = paramazaf.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramazaf)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramazaf, localStream2);
    }
    if (localStream1 != null) {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = paramazaf.d;
        paramazaf.a = System.currentTimeMillis();
        localStream1.subscribe(a(paramazaf));
      }
    }
    while (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramazaf.d;
    this.jdField_a_of_type_Boolean = true;
    paramazaf.a = System.currentTimeMillis();
    localStream2.subscribe(a(paramazaf));
  }
  
  public void a(azal paramazal)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.requestFocus();
    }
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext();
    Intent localIntent = new Intent(localBaseActivity, ShortVideoPlayActivity.class);
    localIntent.putExtra("file_send_path", paramazal.c());
    localIntent.putExtra("video_play_caller", 4);
    localIntent.putExtra("message_click_start", System.currentTimeMillis());
    localBaseActivity.startActivity(localIntent);
    paramazal = new Intent();
    paramazal.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
    paramazal.setPackage(localBaseActivity.getPackageName());
    localBaseActivity.sendBroadcast(paramazal);
  }
  
  protected void a(azbg paramazbg, azaf paramazaf, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramazbg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramazbg.c.setVisibility(0);
      paramazbg.b.setVisibility(4);
      paramazbg.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      paramazbg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramazaf.g)
      {
      default: 
        return;
      case -2147483648: 
      case -2147483647: 
      case -2147483646: 
      case -2147483645: 
        paramazbg.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        paramazbg.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramazbg.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramazaf.e, paramazaf.d);
        paramazbg.b.setVisibility(4);
        paramazbg.c.setVisibility(4);
        return;
      }
    } while (paramazaf.e != 100);
    paramazbg.a();
    return;
    paramazbg.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    paramazbg.b.setVisibility(0);
    paramazbg.c.setVisibility(4);
  }
  
  public void d(azaa paramazaa)
  {
    super.d(paramazaa);
    paramazaa = (azal)paramazaa;
    if (!this.jdField_b_of_type_JavaUtilMap.isEmpty())
    {
      paramazaa = (Stream)this.jdField_b_of_type_JavaUtilMap.get(paramazaa);
      if (paramazaa != null) {
        paramazaa.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbq
 * JD-Core Version:    0.7.0.1
 */