import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bafa
  extends ailz
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final baei jdField_a_of_type_Baei;
  baep jdField_a_of_type_Baep;
  private final baex jdField_a_of_type_Baex;
  private bafd jdField_a_of_type_Bafd;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<agas, baer> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<agas> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bafa(baex parambaex, TroopChatPie paramTroopChatPie)
  {
    super(parambaex.jdField_a_of_type_AndroidContentContext, parambaex.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambaex.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambaex.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambaex.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Baex = parambaex;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Baei = new baei(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bafd = new bafd(this);
    d();
  }
  
  private void a(int paramInt, bafc parambafc)
  {
    agas localagas = (agas)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambafc.c.setImageBitmap(a(localagas.jdField_a_of_type_JavaLangString, 2));
    Object localObject = baes.b(localagas);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localagas.v;
    }
    localObject = new ayjw((CharSequence)localObject, 16).a();
    parambafc.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bbos.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambafc.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambafc.jdField_a_of_type_JavaLangString = localagas.jdField_a_of_type_JavaLangString;
    parambafc.jdField_a_of_type_Int = paramInt;
    bafc.a(parambafc).setTag(parambafc);
    bafc.a(parambafc).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambafc, localagas);
    c(parambafc, localagas);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localagas))
    {
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bafd.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambafc, localagas);
      b(parambafc, localagas);
      return;
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(agas paramagas)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((agas)((Map.Entry)localObject1).getKey()).equals(paramagas)) {
        localObject1 = (baer)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramagas = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramagas.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramagas.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (baer)localEntry.getValue();
        int m = ((baer)localObject2).jdField_a_of_type_Int - ((baer)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new baer(k, ((baer)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bafc)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bafd.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bafd.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Baei.b();
    } while (!this.jdField_a_of_type_Baei.a());
    agas localagas = (agas)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localagas);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Baei.a();
      if ((this.jdField_a_of_type_Bafd.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Baep == null)) {
        break;
      }
      this.jdField_a_of_type_Baep.a();
      return;
      b(localagas);
      a(localagas);
      break label79;
    }
  }
  
  private void a(bafc parambafc)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Baei.a(parambafc.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambafc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Baei.a((String)localObject);
    this.jdField_a_of_type_Bafd.a(parambafc.c);
    localObject = (agas)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bafd.jdField_a_of_type_Boolean)
    {
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambafc.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bafc parambafc, agas paramagas)
  {
    if (parambafc.jdField_a_of_type_AndroidViewView != null)
    {
      bamk localbamk = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbamk == null) || (!localbamk.b(paramagas.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambafc.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambafc.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(agas paramagas)
  {
    paramagas = (baer)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramagas);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramagas != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramagas);
      }
      int i = paramagas.jdField_a_of_type_Int;
      int j = paramagas.jdField_a_of_type_Int;
      localEditable.delete(i, paramagas.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bafc)paramView.getTag();
    paramView = ((bafc)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    agas localagas = (agas)getItem(((bafc)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bafd.a())
      {
        this.jdField_a_of_type_Bafd.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localagas);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Baep != null) && (paramView.b(localagas.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Baep != null) && (!this.jdField_a_of_type_Bafd.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Baep.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localagas.v)) || (!localagas.v.equals(localagas.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localagas);
      a(localagas);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localagas.v))
      {
        paramView = (View)localObject;
        if (localagas.v.equals(localagas.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bafc parambafc, agas paramagas)
  {
    if (parambafc.b != null)
    {
      if (paramagas.jdField_a_of_type_Boolean)
      {
        paramagas = banb.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambafc.b.setBackgroundDrawable(paramagas);
        parambafc.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambafc.b.setVisibility(8);
  }
  
  private void c(agas paramagas)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramagas)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramagas });
    }
    Object localObject;
    do
    {
      return;
      localObject = baes.a(paramagas);
      localObject = bafv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramagas.jdField_a_of_type_JavaLangString, (String)localObject, baes.a(paramagas), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (baes.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      baer localbaer = new baer(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramagas, localbaer);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbaer, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bafc parambafc, agas paramagas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramagas.jdField_a_of_type_JavaLangString))
    {
      bafc.a(parambafc).setVisibility(0);
      paramagas = azrf.a().a(true, false);
      bafc.a(parambafc).setText(paramagas.jdField_a_of_type_JavaLangString);
      paramagas = banb.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramagas.b);
      bafc.a(parambafc).setBackgroundDrawable(paramagas);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramagas.jdField_a_of_type_JavaLangString))
    {
      bafc.a(parambafc).setVisibility(0);
      paramagas = azrf.a().a(false, true);
      bafc.a(parambafc).setText(paramagas.jdField_a_of_type_JavaLangString);
      paramagas = banb.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramagas.b);
      bafc.a(parambafc).setBackgroundDrawable(paramagas);
      return;
    }
    bafc.a(parambafc).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bafb(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  agas a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        agas localagas = (agas)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localagas.jdField_a_of_type_JavaLangString != null) && (localagas.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localagas;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bafd a()
  {
    return this.jdField_a_of_type_Bafd;
  }
  
  public List<agas> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Baex.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(baep parambaep)
  {
    this.jdField_a_of_type_Baep = parambaep;
  }
  
  public void a(baff parambaff)
  {
    this.jdField_a_of_type_JavaUtilList = parambaff.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambaff.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambaff.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambaff.jdField_a_of_type_JavaLangString;
    this.b = parambaff.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Baei.a();
    if (TextUtils.isEmpty(parambaff.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    for (;;)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public void a(List<agas> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return "0".equals(((agas)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i != 1) {
        break label72;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bafd.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Baei != null) {
      this.jdField_a_of_type_Baei.c();
    }
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (a())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label88;
      }
      if (i == 0) {
        break label69;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562552, paramViewGroup, false);
      label37:
      paramViewGroup = new bafc(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (i == 0) {
        break label99;
      }
      a(paramViewGroup);
      return paramView;
      i = 0;
      break;
      label69:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562551, paramViewGroup, false);
      break label37;
      label88:
      paramViewGroup = (bafc)paramView.getTag();
    }
    label99:
    a(paramInt, paramViewGroup);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368344: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafa
 * JD-Core Version:    0.7.0.1
 */