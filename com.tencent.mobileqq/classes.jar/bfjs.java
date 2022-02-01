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
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bfjs
  extends ambr
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final bfja jdField_a_of_type_Bfja;
  bfjh jdField_a_of_type_Bfjh;
  private final bfjp jdField_a_of_type_Bfjp;
  private bfjv jdField_a_of_type_Bfjv;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<ajtt, bfjj> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<ajtt> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bfjs(bfjp parambfjp, TroopChatPie paramTroopChatPie)
  {
    super(parambfjp.jdField_a_of_type_AndroidContentContext, parambfjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfjp.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambfjp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambfjp.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Bfjp = parambfjp;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Bfja = new bfja(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bfjv = new bfjv(this);
    d();
  }
  
  private void a(int paramInt, bfju parambfju)
  {
    ajtt localajtt = (ajtt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambfju.c.setImageBitmap(a(localajtt.jdField_a_of_type_JavaLangString, 2));
    Object localObject = bfjk.b(localajtt);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localajtt.v;
    }
    localObject = new bdnf((CharSequence)localObject, 16).a();
    parambfju.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bgwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambfju.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambfju.jdField_a_of_type_JavaLangString = localajtt.jdField_a_of_type_JavaLangString;
    parambfju.jdField_a_of_type_Int = paramInt;
    bfju.a(parambfju).setTag(parambfju);
    bfju.a(parambfju).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambfju, localajtt);
    c(parambfju, localajtt);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localajtt))
    {
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bfjv.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambfju, localajtt);
      b(parambfju, localajtt);
      return;
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(ajtt paramajtt)
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
      if (((ajtt)((Map.Entry)localObject1).getKey()).equals(paramajtt)) {
        localObject1 = (bfjj)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramajtt = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramajtt.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramajtt.next();
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
        localObject2 = (bfjj)localEntry.getValue();
        int m = ((bfjj)localObject2).jdField_a_of_type_Int - ((bfjj)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bfjj(k, ((bfjj)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bfju)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bfjv.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bfjv.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bfja.b();
    } while (!this.jdField_a_of_type_Bfja.a());
    ajtt localajtt = (ajtt)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localajtt);
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
      this.jdField_a_of_type_Bfja.a();
      if ((this.jdField_a_of_type_Bfjv.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bfjh == null)) {
        break;
      }
      this.jdField_a_of_type_Bfjh.a();
      return;
      b(localajtt);
      a(localajtt);
      break label79;
    }
  }
  
  private void a(bfju parambfju)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bfja.a(parambfju.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambfju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Bfja.a((String)localObject);
    this.jdField_a_of_type_Bfjv.a(parambfju.c);
    localObject = (ajtt)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bfjv.jdField_a_of_type_Boolean)
    {
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambfju.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bfju parambfju, ajtt paramajtt)
  {
    if (parambfju.jdField_a_of_type_AndroidViewView != null)
    {
      bftx localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbftx == null) || (!localbftx.b(paramajtt.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambfju.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambfju.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(ajtt paramajtt)
  {
    paramajtt = (bfjj)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramajtt);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramajtt != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramajtt);
      }
      int i = paramajtt.jdField_a_of_type_Int;
      int j = paramajtt.jdField_a_of_type_Int;
      localEditable.delete(i, paramajtt.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bfju)paramView.getTag();
    paramView = ((bfju)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    ajtt localajtt = (ajtt)getItem(((bfju)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bfjv.a())
      {
        this.jdField_a_of_type_Bfjv.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localajtt);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Bfjh != null) && (paramView.b(localajtt.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Bfjh != null) && (!this.jdField_a_of_type_Bfjv.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Bfjh.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localajtt.v)) || (!localajtt.v.equals(localajtt.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localajtt);
      a(localajtt);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localajtt.v))
      {
        paramView = (View)localObject;
        if (localajtt.v.equals(localajtt.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bfju parambfju, ajtt paramajtt)
  {
    if (parambfju.b != null)
    {
      if (paramajtt.jdField_a_of_type_Boolean)
      {
        paramajtt = bfup.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambfju.b.setBackgroundDrawable(paramajtt);
        parambfju.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambfju.b.setVisibility(8);
  }
  
  private void c(ajtt paramajtt)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramajtt)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramajtt });
    }
    Object localObject;
    do
    {
      return;
      localObject = bfjk.a(paramajtt);
      localObject = bfmd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramajtt.jdField_a_of_type_JavaLangString, (String)localObject, bfjk.a(paramajtt), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (bfjk.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bfjj localbfjj = new bfjj(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramajtt, localbfjj);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbfjj, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bfju parambfju, ajtt paramajtt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramajtt.jdField_a_of_type_JavaLangString))
    {
      bfju.a(parambfju).setVisibility(0);
      paramajtt = beui.a().a(true, false);
      bfju.a(parambfju).setText(paramajtt.jdField_a_of_type_JavaLangString);
      paramajtt = bfup.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajtt.b);
      bfju.a(parambfju).setBackgroundDrawable(paramajtt);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramajtt.jdField_a_of_type_JavaLangString))
    {
      bfju.a(parambfju).setVisibility(0);
      paramajtt = beui.a().a(false, true);
      bfju.a(parambfju).setText(paramajtt.jdField_a_of_type_JavaLangString);
      paramajtt = bfup.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajtt.b);
      bfju.a(parambfju).setBackgroundDrawable(paramajtt);
      return;
    }
    bfju.a(parambfju).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bfjp.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bfjt(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Bfjp.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
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
  
  ajtt a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ajtt localajtt = (ajtt)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localajtt.jdField_a_of_type_JavaLangString != null) && (localajtt.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localajtt;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bfjv a()
  {
    return this.jdField_a_of_type_Bfjv;
  }
  
  public List<ajtt> a()
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
    paramView = this.jdField_a_of_type_Bfjp.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(bfjh parambfjh)
  {
    this.jdField_a_of_type_Bfjh = parambfjh;
  }
  
  public void a(bfjx parambfjx)
  {
    this.jdField_a_of_type_JavaUtilList = parambfjx.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambfjx.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambfjx.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambfjx.jdField_a_of_type_JavaLangString;
    this.b = parambfjx.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bfja.a();
    if (TextUtils.isEmpty(parambfjx.jdField_a_of_type_JavaLangString))
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
  
  public void a(List<ajtt> paramList)
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
    return "0".equals(((ajtt)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
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
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bfjv.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfja != null) {
      this.jdField_a_of_type_Bfja.c();
    }
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
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
    label37:
    bfju localbfju;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563010, paramViewGroup, false);
      localbfju = new bfju(paramView);
      paramView.setTag(localbfju);
      label53:
      if (i == 0) {
        break label117;
      }
      a(localbfju);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563009, paramViewGroup, false);
      break label37;
      label105:
      localbfju = (bfju)paramView.getTag();
      break label53;
      label117:
      a(paramInt, localbfju);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjs
 * JD-Core Version:    0.7.0.1
 */