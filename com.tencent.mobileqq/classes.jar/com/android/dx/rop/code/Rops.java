package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.rop.type.TypeList;

public final class Rops
{
  public static final Rop ADD_CONST_DOUBLE;
  public static final Rop ADD_CONST_FLOAT;
  public static final Rop ADD_CONST_INT;
  public static final Rop ADD_CONST_LONG;
  public static final Rop ADD_DOUBLE;
  public static final Rop ADD_FLOAT;
  public static final Rop ADD_INT;
  public static final Rop ADD_LONG;
  public static final Rop AGET_BOOLEAN;
  public static final Rop AGET_BYTE;
  public static final Rop AGET_CHAR;
  public static final Rop AGET_DOUBLE;
  public static final Rop AGET_FLOAT;
  public static final Rop AGET_INT;
  public static final Rop AGET_LONG;
  public static final Rop AGET_OBJECT;
  public static final Rop AGET_SHORT;
  public static final Rop AND_CONST_INT;
  public static final Rop AND_CONST_LONG;
  public static final Rop AND_INT;
  public static final Rop AND_LONG;
  public static final Rop APUT_BOOLEAN;
  public static final Rop APUT_BYTE;
  public static final Rop APUT_CHAR;
  public static final Rop APUT_DOUBLE;
  public static final Rop APUT_FLOAT;
  public static final Rop APUT_INT;
  public static final Rop APUT_LONG;
  public static final Rop APUT_OBJECT;
  public static final Rop APUT_SHORT;
  public static final Rop ARRAY_LENGTH;
  public static final Rop CHECK_CAST;
  public static final Rop CMPG_DOUBLE;
  public static final Rop CMPG_FLOAT;
  public static final Rop CMPL_DOUBLE;
  public static final Rop CMPL_FLOAT;
  public static final Rop CMPL_LONG;
  public static final Rop CONST_DOUBLE;
  public static final Rop CONST_FLOAT;
  public static final Rop CONST_INT;
  public static final Rop CONST_LONG;
  public static final Rop CONST_OBJECT;
  public static final Rop CONST_OBJECT_NOTHROW;
  public static final Rop CONV_D2F;
  public static final Rop CONV_D2I;
  public static final Rop CONV_D2L;
  public static final Rop CONV_F2D;
  public static final Rop CONV_F2I;
  public static final Rop CONV_F2L;
  public static final Rop CONV_I2D;
  public static final Rop CONV_I2F;
  public static final Rop CONV_I2L;
  public static final Rop CONV_L2D;
  public static final Rop CONV_L2F;
  public static final Rop CONV_L2I;
  public static final Rop DIV_CONST_DOUBLE;
  public static final Rop DIV_CONST_FLOAT;
  public static final Rop DIV_CONST_INT;
  public static final Rop DIV_CONST_LONG;
  public static final Rop DIV_DOUBLE;
  public static final Rop DIV_FLOAT;
  public static final Rop DIV_INT;
  public static final Rop DIV_LONG;
  public static final Rop FILL_ARRAY_DATA = new Rop(57, Type.VOID, StdTypeList.EMPTY, "fill-array-data");
  public static final Rop GET_FIELD_BOOLEAN;
  public static final Rop GET_FIELD_BYTE;
  public static final Rop GET_FIELD_CHAR;
  public static final Rop GET_FIELD_DOUBLE;
  public static final Rop GET_FIELD_FLOAT;
  public static final Rop GET_FIELD_INT;
  public static final Rop GET_FIELD_LONG;
  public static final Rop GET_FIELD_OBJECT;
  public static final Rop GET_FIELD_SHORT;
  public static final Rop GET_STATIC_BOOLEAN;
  public static final Rop GET_STATIC_BYTE;
  public static final Rop GET_STATIC_CHAR;
  public static final Rop GET_STATIC_DOUBLE;
  public static final Rop GET_STATIC_FLOAT;
  public static final Rop GET_STATIC_INT;
  public static final Rop GET_STATIC_LONG;
  public static final Rop GET_STATIC_OBJECT;
  public static final Rop GET_STATIC_SHORT;
  public static final Rop GOTO;
  public static final Rop IF_EQZ_INT;
  public static final Rop IF_EQZ_OBJECT;
  public static final Rop IF_EQ_INT;
  public static final Rop IF_EQ_OBJECT;
  public static final Rop IF_GEZ_INT;
  public static final Rop IF_GE_INT;
  public static final Rop IF_GTZ_INT;
  public static final Rop IF_GT_INT;
  public static final Rop IF_LEZ_INT;
  public static final Rop IF_LE_INT;
  public static final Rop IF_LTZ_INT;
  public static final Rop IF_LT_INT;
  public static final Rop IF_NEZ_INT;
  public static final Rop IF_NEZ_OBJECT;
  public static final Rop IF_NE_INT;
  public static final Rop IF_NE_OBJECT;
  public static final Rop INSTANCE_OF;
  public static final Rop MARK_LOCAL_DOUBLE;
  public static final Rop MARK_LOCAL_FLOAT;
  public static final Rop MARK_LOCAL_INT;
  public static final Rop MARK_LOCAL_LONG;
  public static final Rop MARK_LOCAL_OBJECT;
  public static final Rop MONITOR_ENTER;
  public static final Rop MONITOR_EXIT;
  public static final Rop MOVE_DOUBLE;
  public static final Rop MOVE_FLOAT;
  public static final Rop MOVE_INT;
  public static final Rop MOVE_LONG;
  public static final Rop MOVE_OBJECT;
  public static final Rop MOVE_PARAM_DOUBLE;
  public static final Rop MOVE_PARAM_FLOAT;
  public static final Rop MOVE_PARAM_INT;
  public static final Rop MOVE_PARAM_LONG;
  public static final Rop MOVE_PARAM_OBJECT;
  public static final Rop MOVE_RETURN_ADDRESS;
  public static final Rop MUL_CONST_DOUBLE;
  public static final Rop MUL_CONST_FLOAT;
  public static final Rop MUL_CONST_INT;
  public static final Rop MUL_CONST_LONG;
  public static final Rop MUL_DOUBLE;
  public static final Rop MUL_FLOAT;
  public static final Rop MUL_INT;
  public static final Rop MUL_LONG;
  public static final Rop NEG_DOUBLE;
  public static final Rop NEG_FLOAT;
  public static final Rop NEG_INT;
  public static final Rop NEG_LONG;
  public static final Rop NEW_ARRAY_BOOLEAN;
  public static final Rop NEW_ARRAY_BYTE;
  public static final Rop NEW_ARRAY_CHAR;
  public static final Rop NEW_ARRAY_DOUBLE;
  public static final Rop NEW_ARRAY_FLOAT;
  public static final Rop NEW_ARRAY_INT;
  public static final Rop NEW_ARRAY_LONG;
  public static final Rop NEW_ARRAY_SHORT;
  public static final Rop NEW_INSTANCE;
  public static final Rop NOP = new Rop(1, Type.VOID, StdTypeList.EMPTY, "nop");
  public static final Rop NOT_INT;
  public static final Rop NOT_LONG;
  public static final Rop OR_CONST_INT;
  public static final Rop OR_CONST_LONG;
  public static final Rop OR_INT;
  public static final Rop OR_LONG;
  public static final Rop PUT_FIELD_BOOLEAN;
  public static final Rop PUT_FIELD_BYTE;
  public static final Rop PUT_FIELD_CHAR;
  public static final Rop PUT_FIELD_DOUBLE;
  public static final Rop PUT_FIELD_FLOAT;
  public static final Rop PUT_FIELD_INT;
  public static final Rop PUT_FIELD_LONG;
  public static final Rop PUT_FIELD_OBJECT;
  public static final Rop PUT_FIELD_SHORT;
  public static final Rop PUT_STATIC_BOOLEAN;
  public static final Rop PUT_STATIC_BYTE;
  public static final Rop PUT_STATIC_CHAR;
  public static final Rop PUT_STATIC_DOUBLE;
  public static final Rop PUT_STATIC_FLOAT;
  public static final Rop PUT_STATIC_INT;
  public static final Rop PUT_STATIC_LONG;
  public static final Rop PUT_STATIC_OBJECT;
  public static final Rop PUT_STATIC_SHORT;
  public static final Rop REM_CONST_DOUBLE;
  public static final Rop REM_CONST_FLOAT;
  public static final Rop REM_CONST_INT;
  public static final Rop REM_CONST_LONG;
  public static final Rop REM_DOUBLE;
  public static final Rop REM_FLOAT;
  public static final Rop REM_INT;
  public static final Rop REM_LONG;
  public static final Rop RETURN_DOUBLE;
  public static final Rop RETURN_FLOAT;
  public static final Rop RETURN_INT;
  public static final Rop RETURN_LONG;
  public static final Rop RETURN_OBJECT;
  public static final Rop RETURN_VOID;
  public static final Rop SHL_CONST_INT;
  public static final Rop SHL_CONST_LONG;
  public static final Rop SHL_INT;
  public static final Rop SHL_LONG;
  public static final Rop SHR_CONST_INT;
  public static final Rop SHR_CONST_LONG;
  public static final Rop SHR_INT;
  public static final Rop SHR_LONG;
  public static final Rop SUB_CONST_DOUBLE;
  public static final Rop SUB_CONST_FLOAT;
  public static final Rop SUB_CONST_INT;
  public static final Rop SUB_CONST_LONG;
  public static final Rop SUB_DOUBLE;
  public static final Rop SUB_FLOAT;
  public static final Rop SUB_INT;
  public static final Rop SUB_LONG;
  public static final Rop SWITCH;
  public static final Rop THROW;
  public static final Rop TO_BYTE;
  public static final Rop TO_CHAR;
  public static final Rop TO_SHORT;
  public static final Rop USHR_CONST_INT;
  public static final Rop USHR_CONST_LONG;
  public static final Rop USHR_INT;
  public static final Rop USHR_LONG;
  public static final Rop XOR_CONST_INT;
  public static final Rop XOR_CONST_LONG;
  public static final Rop XOR_INT;
  public static final Rop XOR_LONG;
  
  static
  {
    MOVE_INT = new Rop(2, Type.INT, StdTypeList.INT, "move-int");
    MOVE_LONG = new Rop(2, Type.LONG, StdTypeList.LONG, "move-long");
    MOVE_FLOAT = new Rop(2, Type.FLOAT, StdTypeList.FLOAT, "move-float");
    MOVE_DOUBLE = new Rop(2, Type.DOUBLE, StdTypeList.DOUBLE, "move-double");
    MOVE_OBJECT = new Rop(2, Type.OBJECT, StdTypeList.OBJECT, "move-object");
    MOVE_RETURN_ADDRESS = new Rop(2, Type.RETURN_ADDRESS, StdTypeList.RETURN_ADDRESS, "move-return-address");
    MOVE_PARAM_INT = new Rop(3, Type.INT, StdTypeList.EMPTY, "move-param-int");
    MOVE_PARAM_LONG = new Rop(3, Type.LONG, StdTypeList.EMPTY, "move-param-long");
    MOVE_PARAM_FLOAT = new Rop(3, Type.FLOAT, StdTypeList.EMPTY, "move-param-float");
    MOVE_PARAM_DOUBLE = new Rop(3, Type.DOUBLE, StdTypeList.EMPTY, "move-param-double");
    MOVE_PARAM_OBJECT = new Rop(3, Type.OBJECT, StdTypeList.EMPTY, "move-param-object");
    CONST_INT = new Rop(5, Type.INT, StdTypeList.EMPTY, "const-int");
    CONST_LONG = new Rop(5, Type.LONG, StdTypeList.EMPTY, "const-long");
    CONST_FLOAT = new Rop(5, Type.FLOAT, StdTypeList.EMPTY, "const-float");
    CONST_DOUBLE = new Rop(5, Type.DOUBLE, StdTypeList.EMPTY, "const-double");
    CONST_OBJECT = new Rop(5, Type.OBJECT, StdTypeList.EMPTY, Exceptions.LIST_Error, "const-object");
    CONST_OBJECT_NOTHROW = new Rop(5, Type.OBJECT, StdTypeList.EMPTY, "const-object-nothrow");
    GOTO = new Rop(6, Type.VOID, StdTypeList.EMPTY, 3, "goto");
    IF_EQZ_INT = new Rop(7, Type.VOID, StdTypeList.INT, 4, "if-eqz-int");
    IF_NEZ_INT = new Rop(8, Type.VOID, StdTypeList.INT, 4, "if-nez-int");
    IF_LTZ_INT = new Rop(9, Type.VOID, StdTypeList.INT, 4, "if-ltz-int");
    IF_GEZ_INT = new Rop(10, Type.VOID, StdTypeList.INT, 4, "if-gez-int");
    IF_LEZ_INT = new Rop(11, Type.VOID, StdTypeList.INT, 4, "if-lez-int");
    IF_GTZ_INT = new Rop(12, Type.VOID, StdTypeList.INT, 4, "if-gtz-int");
    IF_EQZ_OBJECT = new Rop(7, Type.VOID, StdTypeList.OBJECT, 4, "if-eqz-object");
    IF_NEZ_OBJECT = new Rop(8, Type.VOID, StdTypeList.OBJECT, 4, "if-nez-object");
    IF_EQ_INT = new Rop(7, Type.VOID, StdTypeList.INT_INT, 4, "if-eq-int");
    IF_NE_INT = new Rop(8, Type.VOID, StdTypeList.INT_INT, 4, "if-ne-int");
    IF_LT_INT = new Rop(9, Type.VOID, StdTypeList.INT_INT, 4, "if-lt-int");
    IF_GE_INT = new Rop(10, Type.VOID, StdTypeList.INT_INT, 4, "if-ge-int");
    IF_LE_INT = new Rop(11, Type.VOID, StdTypeList.INT_INT, 4, "if-le-int");
    IF_GT_INT = new Rop(12, Type.VOID, StdTypeList.INT_INT, 4, "if-gt-int");
    IF_EQ_OBJECT = new Rop(7, Type.VOID, StdTypeList.OBJECT_OBJECT, 4, "if-eq-object");
    IF_NE_OBJECT = new Rop(8, Type.VOID, StdTypeList.OBJECT_OBJECT, 4, "if-ne-object");
    SWITCH = new Rop(13, Type.VOID, StdTypeList.INT, 5, "switch");
    ADD_INT = new Rop(14, Type.INT, StdTypeList.INT_INT, "add-int");
    ADD_LONG = new Rop(14, Type.LONG, StdTypeList.LONG_LONG, "add-long");
    ADD_FLOAT = new Rop(14, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "add-float");
    ADD_DOUBLE = new Rop(14, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, 1, "add-double");
    SUB_INT = new Rop(15, Type.INT, StdTypeList.INT_INT, "sub-int");
    SUB_LONG = new Rop(15, Type.LONG, StdTypeList.LONG_LONG, "sub-long");
    SUB_FLOAT = new Rop(15, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "sub-float");
    SUB_DOUBLE = new Rop(15, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, 1, "sub-double");
    MUL_INT = new Rop(16, Type.INT, StdTypeList.INT_INT, "mul-int");
    MUL_LONG = new Rop(16, Type.LONG, StdTypeList.LONG_LONG, "mul-long");
    MUL_FLOAT = new Rop(16, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "mul-float");
    MUL_DOUBLE = new Rop(16, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, 1, "mul-double");
    DIV_INT = new Rop(17, Type.INT, StdTypeList.INT_INT, Exceptions.LIST_Error_ArithmeticException, "div-int");
    DIV_LONG = new Rop(17, Type.LONG, StdTypeList.LONG_LONG, Exceptions.LIST_Error_ArithmeticException, "div-long");
    DIV_FLOAT = new Rop(17, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "div-float");
    DIV_DOUBLE = new Rop(17, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, "div-double");
    REM_INT = new Rop(18, Type.INT, StdTypeList.INT_INT, Exceptions.LIST_Error_ArithmeticException, "rem-int");
    REM_LONG = new Rop(18, Type.LONG, StdTypeList.LONG_LONG, Exceptions.LIST_Error_ArithmeticException, "rem-long");
    REM_FLOAT = new Rop(18, Type.FLOAT, StdTypeList.FLOAT_FLOAT, "rem-float");
    REM_DOUBLE = new Rop(18, Type.DOUBLE, StdTypeList.DOUBLE_DOUBLE, "rem-double");
    NEG_INT = new Rop(19, Type.INT, StdTypeList.INT, "neg-int");
    NEG_LONG = new Rop(19, Type.LONG, StdTypeList.LONG, "neg-long");
    NEG_FLOAT = new Rop(19, Type.FLOAT, StdTypeList.FLOAT, "neg-float");
    NEG_DOUBLE = new Rop(19, Type.DOUBLE, StdTypeList.DOUBLE, "neg-double");
    AND_INT = new Rop(20, Type.INT, StdTypeList.INT_INT, "and-int");
    AND_LONG = new Rop(20, Type.LONG, StdTypeList.LONG_LONG, "and-long");
    OR_INT = new Rop(21, Type.INT, StdTypeList.INT_INT, "or-int");
    OR_LONG = new Rop(21, Type.LONG, StdTypeList.LONG_LONG, "or-long");
    XOR_INT = new Rop(22, Type.INT, StdTypeList.INT_INT, "xor-int");
    XOR_LONG = new Rop(22, Type.LONG, StdTypeList.LONG_LONG, "xor-long");
    SHL_INT = new Rop(23, Type.INT, StdTypeList.INT_INT, "shl-int");
    SHL_LONG = new Rop(23, Type.LONG, StdTypeList.LONG_INT, "shl-long");
    SHR_INT = new Rop(24, Type.INT, StdTypeList.INT_INT, "shr-int");
    SHR_LONG = new Rop(24, Type.LONG, StdTypeList.LONG_INT, "shr-long");
    USHR_INT = new Rop(25, Type.INT, StdTypeList.INT_INT, "ushr-int");
    USHR_LONG = new Rop(25, Type.LONG, StdTypeList.LONG_INT, "ushr-long");
    NOT_INT = new Rop(26, Type.INT, StdTypeList.INT, "not-int");
    NOT_LONG = new Rop(26, Type.LONG, StdTypeList.LONG, "not-long");
    ADD_CONST_INT = new Rop(14, Type.INT, StdTypeList.INT, "add-const-int");
    ADD_CONST_LONG = new Rop(14, Type.LONG, StdTypeList.LONG, "add-const-long");
    ADD_CONST_FLOAT = new Rop(14, Type.FLOAT, StdTypeList.FLOAT, "add-const-float");
    ADD_CONST_DOUBLE = new Rop(14, Type.DOUBLE, StdTypeList.DOUBLE, "add-const-double");
    SUB_CONST_INT = new Rop(15, Type.INT, StdTypeList.INT, "sub-const-int");
    SUB_CONST_LONG = new Rop(15, Type.LONG, StdTypeList.LONG, "sub-const-long");
    SUB_CONST_FLOAT = new Rop(15, Type.FLOAT, StdTypeList.FLOAT, "sub-const-float");
    SUB_CONST_DOUBLE = new Rop(15, Type.DOUBLE, StdTypeList.DOUBLE, "sub-const-double");
    MUL_CONST_INT = new Rop(16, Type.INT, StdTypeList.INT, "mul-const-int");
    MUL_CONST_LONG = new Rop(16, Type.LONG, StdTypeList.LONG, "mul-const-long");
    MUL_CONST_FLOAT = new Rop(16, Type.FLOAT, StdTypeList.FLOAT, "mul-const-float");
    MUL_CONST_DOUBLE = new Rop(16, Type.DOUBLE, StdTypeList.DOUBLE, "mul-const-double");
    DIV_CONST_INT = new Rop(17, Type.INT, StdTypeList.INT, Exceptions.LIST_Error_ArithmeticException, "div-const-int");
    DIV_CONST_LONG = new Rop(17, Type.LONG, StdTypeList.LONG, Exceptions.LIST_Error_ArithmeticException, "div-const-long");
    DIV_CONST_FLOAT = new Rop(17, Type.FLOAT, StdTypeList.FLOAT, "div-const-float");
    DIV_CONST_DOUBLE = new Rop(17, Type.DOUBLE, StdTypeList.DOUBLE, "div-const-double");
    REM_CONST_INT = new Rop(18, Type.INT, StdTypeList.INT, Exceptions.LIST_Error_ArithmeticException, "rem-const-int");
    REM_CONST_LONG = new Rop(18, Type.LONG, StdTypeList.LONG, Exceptions.LIST_Error_ArithmeticException, "rem-const-long");
    REM_CONST_FLOAT = new Rop(18, Type.FLOAT, StdTypeList.FLOAT, "rem-const-float");
    REM_CONST_DOUBLE = new Rop(18, Type.DOUBLE, StdTypeList.DOUBLE, "rem-const-double");
    AND_CONST_INT = new Rop(20, Type.INT, StdTypeList.INT, "and-const-int");
    AND_CONST_LONG = new Rop(20, Type.LONG, StdTypeList.LONG, "and-const-long");
    OR_CONST_INT = new Rop(21, Type.INT, StdTypeList.INT, "or-const-int");
    OR_CONST_LONG = new Rop(21, Type.LONG, StdTypeList.LONG, "or-const-long");
    XOR_CONST_INT = new Rop(22, Type.INT, StdTypeList.INT, "xor-const-int");
    XOR_CONST_LONG = new Rop(22, Type.LONG, StdTypeList.LONG, "xor-const-long");
    SHL_CONST_INT = new Rop(23, Type.INT, StdTypeList.INT, "shl-const-int");
    SHL_CONST_LONG = new Rop(23, Type.LONG, StdTypeList.INT, "shl-const-long");
    SHR_CONST_INT = new Rop(24, Type.INT, StdTypeList.INT, "shr-const-int");
    SHR_CONST_LONG = new Rop(24, Type.LONG, StdTypeList.INT, "shr-const-long");
    USHR_CONST_INT = new Rop(25, Type.INT, StdTypeList.INT, "ushr-const-int");
    USHR_CONST_LONG = new Rop(25, Type.LONG, StdTypeList.INT, "ushr-const-long");
    CMPL_LONG = new Rop(27, Type.INT, StdTypeList.LONG_LONG, "cmpl-long");
    CMPL_FLOAT = new Rop(27, Type.INT, StdTypeList.FLOAT_FLOAT, "cmpl-float");
    CMPL_DOUBLE = new Rop(27, Type.INT, StdTypeList.DOUBLE_DOUBLE, "cmpl-double");
    CMPG_FLOAT = new Rop(28, Type.INT, StdTypeList.FLOAT_FLOAT, "cmpg-float");
    CMPG_DOUBLE = new Rop(28, Type.INT, StdTypeList.DOUBLE_DOUBLE, "cmpg-double");
    CONV_L2I = new Rop(29, Type.INT, StdTypeList.LONG, "conv-l2i");
    CONV_F2I = new Rop(29, Type.INT, StdTypeList.FLOAT, "conv-f2i");
    CONV_D2I = new Rop(29, Type.INT, StdTypeList.DOUBLE, "conv-d2i");
    CONV_I2L = new Rop(29, Type.LONG, StdTypeList.INT, "conv-i2l");
    CONV_F2L = new Rop(29, Type.LONG, StdTypeList.FLOAT, "conv-f2l");
    CONV_D2L = new Rop(29, Type.LONG, StdTypeList.DOUBLE, "conv-d2l");
    CONV_I2F = new Rop(29, Type.FLOAT, StdTypeList.INT, "conv-i2f");
    CONV_L2F = new Rop(29, Type.FLOAT, StdTypeList.LONG, "conv-l2f");
    CONV_D2F = new Rop(29, Type.FLOAT, StdTypeList.DOUBLE, "conv-d2f");
    CONV_I2D = new Rop(29, Type.DOUBLE, StdTypeList.INT, "conv-i2d");
    CONV_L2D = new Rop(29, Type.DOUBLE, StdTypeList.LONG, "conv-l2d");
    CONV_F2D = new Rop(29, Type.DOUBLE, StdTypeList.FLOAT, "conv-f2d");
    TO_BYTE = new Rop(30, Type.INT, StdTypeList.INT, "to-byte");
    TO_CHAR = new Rop(31, Type.INT, StdTypeList.INT, "to-char");
    TO_SHORT = new Rop(32, Type.INT, StdTypeList.INT, "to-short");
    RETURN_VOID = new Rop(33, Type.VOID, StdTypeList.EMPTY, 2, "return-void");
    RETURN_INT = new Rop(33, Type.VOID, StdTypeList.INT, 2, "return-int");
    RETURN_LONG = new Rop(33, Type.VOID, StdTypeList.LONG, 2, "return-long");
    RETURN_FLOAT = new Rop(33, Type.VOID, StdTypeList.FLOAT, 2, "return-float");
    RETURN_DOUBLE = new Rop(33, Type.VOID, StdTypeList.DOUBLE, 2, "return-double");
    RETURN_OBJECT = new Rop(33, Type.VOID, StdTypeList.OBJECT, 2, "return-object");
    ARRAY_LENGTH = new Rop(34, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "array-length");
    THROW = new Rop(35, Type.VOID, StdTypeList.THROWABLE, StdTypeList.THROWABLE, "throw");
    MONITOR_ENTER = new Rop(36, Type.VOID, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "monitor-enter");
    MONITOR_EXIT = new Rop(37, Type.VOID, StdTypeList.OBJECT, Exceptions.LIST_Error_Null_IllegalMonitorStateException, "monitor-exit");
    AGET_INT = new Rop(38, Type.INT, StdTypeList.INTARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-int");
    AGET_LONG = new Rop(38, Type.LONG, StdTypeList.LONGARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-long");
    AGET_FLOAT = new Rop(38, Type.FLOAT, StdTypeList.FLOATARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-float");
    AGET_DOUBLE = new Rop(38, Type.DOUBLE, StdTypeList.DOUBLEARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-double");
    AGET_OBJECT = new Rop(38, Type.OBJECT, StdTypeList.OBJECTARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-object");
    AGET_BOOLEAN = new Rop(38, Type.INT, StdTypeList.BOOLEANARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-boolean");
    AGET_BYTE = new Rop(38, Type.INT, StdTypeList.BYTEARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-byte");
    AGET_CHAR = new Rop(38, Type.INT, StdTypeList.CHARARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-char");
    AGET_SHORT = new Rop(38, Type.INT, StdTypeList.SHORTARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aget-short");
    APUT_INT = new Rop(39, Type.VOID, StdTypeList.INT_INTARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-int");
    APUT_LONG = new Rop(39, Type.VOID, StdTypeList.LONG_LONGARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-long");
    APUT_FLOAT = new Rop(39, Type.VOID, StdTypeList.FLOAT_FLOATARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-float");
    APUT_DOUBLE = new Rop(39, Type.VOID, StdTypeList.DOUBLE_DOUBLEARR_INT, Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds, "aput-double");
    APUT_OBJECT = new Rop(39, Type.VOID, StdTypeList.OBJECT_OBJECTARR_INT, Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-object");
    APUT_BOOLEAN = new Rop(39, Type.VOID, StdTypeList.INT_BOOLEANARR_INT, Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-boolean");
    APUT_BYTE = new Rop(39, Type.VOID, StdTypeList.INT_BYTEARR_INT, Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-byte");
    APUT_CHAR = new Rop(39, Type.VOID, StdTypeList.INT_CHARARR_INT, Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-char");
    APUT_SHORT = new Rop(39, Type.VOID, StdTypeList.INT_SHORTARR_INT, Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore, "aput-short");
    NEW_INSTANCE = new Rop(40, Type.OBJECT, StdTypeList.EMPTY, Exceptions.LIST_Error, "new-instance");
    NEW_ARRAY_INT = new Rop(41, Type.INT_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-int");
    NEW_ARRAY_LONG = new Rop(41, Type.LONG_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-long");
    NEW_ARRAY_FLOAT = new Rop(41, Type.FLOAT_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-float");
    NEW_ARRAY_DOUBLE = new Rop(41, Type.DOUBLE_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-double");
    NEW_ARRAY_BOOLEAN = new Rop(41, Type.BOOLEAN_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-boolean");
    NEW_ARRAY_BYTE = new Rop(41, Type.BYTE_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-byte");
    NEW_ARRAY_CHAR = new Rop(41, Type.CHAR_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-char");
    NEW_ARRAY_SHORT = new Rop(41, Type.SHORT_ARRAY, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-short");
    CHECK_CAST = new Rop(43, Type.VOID, StdTypeList.OBJECT, Exceptions.LIST_Error_ClassCastException, "check-cast");
    INSTANCE_OF = new Rop(44, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error, "instance-of");
    GET_FIELD_INT = new Rop(45, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-int");
    GET_FIELD_LONG = new Rop(45, Type.LONG, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-long");
    GET_FIELD_FLOAT = new Rop(45, Type.FLOAT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-float");
    GET_FIELD_DOUBLE = new Rop(45, Type.DOUBLE, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-double");
    GET_FIELD_OBJECT = new Rop(45, Type.OBJECT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-object");
    GET_FIELD_BOOLEAN = new Rop(45, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-boolean");
    GET_FIELD_BYTE = new Rop(45, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-byte");
    GET_FIELD_CHAR = new Rop(45, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-char");
    GET_FIELD_SHORT = new Rop(45, Type.INT, StdTypeList.OBJECT, Exceptions.LIST_Error_NullPointerException, "get-field-short");
    GET_STATIC_INT = new Rop(46, Type.INT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-static-int");
    GET_STATIC_LONG = new Rop(46, Type.LONG, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-static-long");
    GET_STATIC_FLOAT = new Rop(46, Type.FLOAT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-static-float");
    GET_STATIC_DOUBLE = new Rop(46, Type.DOUBLE, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-static-double");
    GET_STATIC_OBJECT = new Rop(46, Type.OBJECT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-static-object");
    GET_STATIC_BOOLEAN = new Rop(46, Type.INT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-field-boolean");
    GET_STATIC_BYTE = new Rop(46, Type.INT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-field-byte");
    GET_STATIC_CHAR = new Rop(46, Type.INT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-field-char");
    GET_STATIC_SHORT = new Rop(46, Type.INT, StdTypeList.EMPTY, Exceptions.LIST_Error, "get-field-short");
    PUT_FIELD_INT = new Rop(47, Type.VOID, StdTypeList.INT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-int");
    PUT_FIELD_LONG = new Rop(47, Type.VOID, StdTypeList.LONG_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-long");
    PUT_FIELD_FLOAT = new Rop(47, Type.VOID, StdTypeList.FLOAT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-float");
    PUT_FIELD_DOUBLE = new Rop(47, Type.VOID, StdTypeList.DOUBLE_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-double");
    PUT_FIELD_OBJECT = new Rop(47, Type.VOID, StdTypeList.OBJECT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-object");
    PUT_FIELD_BOOLEAN = new Rop(47, Type.VOID, StdTypeList.INT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-boolean");
    PUT_FIELD_BYTE = new Rop(47, Type.VOID, StdTypeList.INT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-byte");
    PUT_FIELD_CHAR = new Rop(47, Type.VOID, StdTypeList.INT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-char");
    PUT_FIELD_SHORT = new Rop(47, Type.VOID, StdTypeList.INT_OBJECT, Exceptions.LIST_Error_NullPointerException, "put-field-short");
    PUT_STATIC_INT = new Rop(48, Type.VOID, StdTypeList.INT, Exceptions.LIST_Error, "put-static-int");
    PUT_STATIC_LONG = new Rop(48, Type.VOID, StdTypeList.LONG, Exceptions.LIST_Error, "put-static-long");
    PUT_STATIC_FLOAT = new Rop(48, Type.VOID, StdTypeList.FLOAT, Exceptions.LIST_Error, "put-static-float");
    PUT_STATIC_DOUBLE = new Rop(48, Type.VOID, StdTypeList.DOUBLE, Exceptions.LIST_Error, "put-static-double");
    PUT_STATIC_OBJECT = new Rop(48, Type.VOID, StdTypeList.OBJECT, Exceptions.LIST_Error, "put-static-object");
    PUT_STATIC_BOOLEAN = new Rop(48, Type.VOID, StdTypeList.INT, Exceptions.LIST_Error, "put-static-boolean");
    PUT_STATIC_BYTE = new Rop(48, Type.VOID, StdTypeList.INT, Exceptions.LIST_Error, "put-static-byte");
    PUT_STATIC_CHAR = new Rop(48, Type.VOID, StdTypeList.INT, Exceptions.LIST_Error, "put-static-char");
    PUT_STATIC_SHORT = new Rop(48, Type.VOID, StdTypeList.INT, Exceptions.LIST_Error, "put-static-short");
    MARK_LOCAL_INT = new Rop(54, Type.VOID, StdTypeList.INT, "mark-local-int");
    MARK_LOCAL_LONG = new Rop(54, Type.VOID, StdTypeList.LONG, "mark-local-long");
    MARK_LOCAL_FLOAT = new Rop(54, Type.VOID, StdTypeList.FLOAT, "mark-local-float");
    MARK_LOCAL_DOUBLE = new Rop(54, Type.VOID, StdTypeList.DOUBLE, "mark-local-double");
    MARK_LOCAL_OBJECT = new Rop(54, Type.VOID, StdTypeList.OBJECT, "mark-local-object");
  }
  
  public static Rop opAdd(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, ADD_CONST_INT, ADD_CONST_LONG, ADD_CONST_FLOAT, ADD_CONST_DOUBLE, ADD_INT, ADD_LONG, ADD_FLOAT, ADD_DOUBLE);
  }
  
  public static Rop opAget(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return AGET_INT;
    case 7: 
      return AGET_LONG;
    case 5: 
      return AGET_FLOAT;
    case 4: 
      return AGET_DOUBLE;
    case 9: 
      return AGET_OBJECT;
    case 1: 
      return AGET_BOOLEAN;
    case 2: 
      return AGET_BYTE;
    case 3: 
      return AGET_CHAR;
    }
    return AGET_SHORT;
  }
  
  public static Rop opAnd(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, AND_CONST_INT, AND_CONST_LONG, null, null, AND_INT, AND_LONG, null, null);
  }
  
  public static Rop opAput(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return APUT_INT;
    case 7: 
      return APUT_LONG;
    case 5: 
      return APUT_FLOAT;
    case 4: 
      return APUT_DOUBLE;
    case 9: 
      return APUT_OBJECT;
    case 1: 
      return APUT_BOOLEAN;
    case 2: 
      return APUT_BYTE;
    case 3: 
      return APUT_CHAR;
    }
    return APUT_SHORT;
  }
  
  public static Rop opCmpg(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 5: 
      return CMPG_FLOAT;
    }
    return CMPG_DOUBLE;
  }
  
  public static Rop opCmpl(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    case 6: 
    default: 
      return throwBadType(paramTypeBearer);
    case 7: 
      return CMPL_LONG;
    case 5: 
      return CMPL_FLOAT;
    }
    return CMPL_DOUBLE;
  }
  
  public static Rop opConst(TypeBearer paramTypeBearer)
  {
    if (paramTypeBearer.getType() == Type.KNOWN_NULL) {
      return CONST_OBJECT_NOTHROW;
    }
    switch (paramTypeBearer.getBasicFrameType())
    {
    case 8: 
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return CONST_INT;
    case 7: 
      return CONST_LONG;
    case 5: 
      return CONST_FLOAT;
    case 4: 
      return CONST_DOUBLE;
    }
    return CONST_OBJECT;
  }
  
  public static Rop opConv(TypeBearer paramTypeBearer1, TypeBearer paramTypeBearer2)
  {
    int i = paramTypeBearer1.getBasicFrameType();
    switch (paramTypeBearer2.getBasicFrameType())
    {
    }
    for (;;)
    {
      return throwBadTypes(StdTypeList.make(paramTypeBearer1.getType(), paramTypeBearer2.getType()));
      switch (i)
      {
      case 6: 
      default: 
        switch (i)
        {
        default: 
          switch (i)
          {
          case 5: 
          default: 
            switch (i)
            {
            }
            break;
          }
          break;
        }
        break;
      }
    }
    return CONV_D2F;
    return CONV_I2L;
    return CONV_I2F;
    return CONV_I2D;
    return CONV_L2I;
    return CONV_L2F;
    return CONV_L2D;
    return CONV_F2I;
    return CONV_F2L;
    return CONV_F2D;
    return CONV_D2I;
    return CONV_D2L;
  }
  
  public static Rop opDiv(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, DIV_CONST_INT, DIV_CONST_LONG, DIV_CONST_FLOAT, DIV_CONST_DOUBLE, DIV_INT, DIV_LONG, DIV_FLOAT, DIV_DOUBLE);
  }
  
  public static Rop opFilledNewArray(TypeBearer paramTypeBearer, int paramInt)
  {
    Type localType = paramTypeBearer.getType().getComponentType();
    if (localType.isCategory2()) {
      return throwBadType(paramTypeBearer);
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("count < 0");
    }
    paramTypeBearer = new StdTypeList(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      paramTypeBearer.set(i, localType);
      i += 1;
    }
    return new Rop(42, paramTypeBearer, Exceptions.LIST_Error);
  }
  
  public static Rop opGetField(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return GET_FIELD_INT;
    case 7: 
      return GET_FIELD_LONG;
    case 5: 
      return GET_FIELD_FLOAT;
    case 4: 
      return GET_FIELD_DOUBLE;
    case 9: 
      return GET_FIELD_OBJECT;
    case 1: 
      return GET_FIELD_BOOLEAN;
    case 2: 
      return GET_FIELD_BYTE;
    case 3: 
      return GET_FIELD_CHAR;
    }
    return GET_FIELD_SHORT;
  }
  
  public static Rop opGetStatic(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return GET_STATIC_INT;
    case 7: 
      return GET_STATIC_LONG;
    case 5: 
      return GET_STATIC_FLOAT;
    case 4: 
      return GET_STATIC_DOUBLE;
    case 9: 
      return GET_STATIC_OBJECT;
    case 1: 
      return GET_STATIC_BOOLEAN;
    case 2: 
      return GET_STATIC_BYTE;
    case 3: 
      return GET_STATIC_CHAR;
    }
    return GET_STATIC_SHORT;
  }
  
  public static Rop opIfEq(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_EQZ_INT, IF_EQZ_OBJECT, IF_EQ_INT, IF_EQ_OBJECT);
  }
  
  public static Rop opIfGe(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_GEZ_INT, null, IF_GE_INT, null);
  }
  
  public static Rop opIfGt(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_GTZ_INT, null, IF_GT_INT, null);
  }
  
  public static Rop opIfLe(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_LEZ_INT, null, IF_LE_INT, null);
  }
  
  public static Rop opIfLt(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_LTZ_INT, null, IF_LT_INT, null);
  }
  
  public static Rop opIfNe(TypeList paramTypeList)
  {
    return pickIf(paramTypeList, IF_NEZ_INT, IF_NEZ_OBJECT, IF_NE_INT, IF_NE_OBJECT);
  }
  
  public static Rop opInvokeDirect(Prototype paramPrototype)
  {
    return new Rop(52, paramPrototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
  }
  
  public static Rop opInvokeInterface(Prototype paramPrototype)
  {
    return new Rop(53, paramPrototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
  }
  
  public static Rop opInvokeStatic(Prototype paramPrototype)
  {
    return new Rop(49, paramPrototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
  }
  
  public static Rop opInvokeSuper(Prototype paramPrototype)
  {
    return new Rop(51, paramPrototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
  }
  
  public static Rop opInvokeVirtual(Prototype paramPrototype)
  {
    return new Rop(50, paramPrototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
  }
  
  public static Rop opMarkLocal(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    case 8: 
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return MARK_LOCAL_INT;
    case 7: 
      return MARK_LOCAL_LONG;
    case 5: 
      return MARK_LOCAL_FLOAT;
    case 4: 
      return MARK_LOCAL_DOUBLE;
    }
    return MARK_LOCAL_OBJECT;
  }
  
  public static Rop opMove(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    case 8: 
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return MOVE_INT;
    case 7: 
      return MOVE_LONG;
    case 5: 
      return MOVE_FLOAT;
    case 4: 
      return MOVE_DOUBLE;
    case 9: 
      return MOVE_OBJECT;
    }
    return MOVE_RETURN_ADDRESS;
  }
  
  public static Rop opMoveException(TypeBearer paramTypeBearer)
  {
    return new Rop(4, paramTypeBearer.getType(), StdTypeList.EMPTY, (String)null);
  }
  
  public static Rop opMoveParam(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    case 8: 
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return MOVE_PARAM_INT;
    case 7: 
      return MOVE_PARAM_LONG;
    case 5: 
      return MOVE_PARAM_FLOAT;
    case 4: 
      return MOVE_PARAM_DOUBLE;
    }
    return MOVE_PARAM_OBJECT;
  }
  
  public static Rop opMoveResult(TypeBearer paramTypeBearer)
  {
    return new Rop(55, paramTypeBearer.getType(), StdTypeList.EMPTY, (String)null);
  }
  
  public static Rop opMoveResultPseudo(TypeBearer paramTypeBearer)
  {
    return new Rop(56, paramTypeBearer.getType(), StdTypeList.EMPTY, (String)null);
  }
  
  public static Rop opMul(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, MUL_CONST_INT, MUL_CONST_LONG, MUL_CONST_FLOAT, MUL_CONST_DOUBLE, MUL_INT, MUL_LONG, MUL_FLOAT, MUL_DOUBLE);
  }
  
  public static Rop opNeg(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return NEG_INT;
    case 7: 
      return NEG_LONG;
    case 5: 
      return NEG_FLOAT;
    }
    return NEG_DOUBLE;
  }
  
  public static Rop opNewArray(TypeBearer paramTypeBearer)
  {
    paramTypeBearer = paramTypeBearer.getType();
    switch (paramTypeBearer.getComponentType().getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return NEW_ARRAY_INT;
    case 7: 
      return NEW_ARRAY_LONG;
    case 5: 
      return NEW_ARRAY_FLOAT;
    case 4: 
      return NEW_ARRAY_DOUBLE;
    case 1: 
      return NEW_ARRAY_BOOLEAN;
    case 2: 
      return NEW_ARRAY_BYTE;
    case 3: 
      return NEW_ARRAY_CHAR;
    case 8: 
      return NEW_ARRAY_SHORT;
    }
    return new Rop(41, paramTypeBearer, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-object");
  }
  
  public static Rop opNot(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return NOT_INT;
    }
    return NOT_LONG;
  }
  
  public static Rop opOr(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, OR_CONST_INT, OR_CONST_LONG, null, null, OR_INT, OR_LONG, null, null);
  }
  
  public static Rop opPutField(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return PUT_FIELD_INT;
    case 7: 
      return PUT_FIELD_LONG;
    case 5: 
      return PUT_FIELD_FLOAT;
    case 4: 
      return PUT_FIELD_DOUBLE;
    case 9: 
      return PUT_FIELD_OBJECT;
    case 1: 
      return PUT_FIELD_BOOLEAN;
    case 2: 
      return PUT_FIELD_BYTE;
    case 3: 
      return PUT_FIELD_CHAR;
    }
    return PUT_FIELD_SHORT;
  }
  
  public static Rop opPutStatic(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicType())
    {
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return PUT_STATIC_INT;
    case 7: 
      return PUT_STATIC_LONG;
    case 5: 
      return PUT_STATIC_FLOAT;
    case 4: 
      return PUT_STATIC_DOUBLE;
    case 9: 
      return PUT_STATIC_OBJECT;
    case 1: 
      return PUT_STATIC_BOOLEAN;
    case 2: 
      return PUT_STATIC_BYTE;
    case 3: 
      return PUT_STATIC_CHAR;
    }
    return PUT_STATIC_SHORT;
  }
  
  public static Rop opRem(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, REM_CONST_INT, REM_CONST_LONG, REM_CONST_FLOAT, REM_CONST_DOUBLE, REM_INT, REM_LONG, REM_FLOAT, REM_DOUBLE);
  }
  
  public static Rop opReturn(TypeBearer paramTypeBearer)
  {
    switch (paramTypeBearer.getBasicFrameType())
    {
    case 1: 
    case 2: 
    case 3: 
    case 8: 
    default: 
      return throwBadType(paramTypeBearer);
    case 6: 
      return RETURN_INT;
    case 7: 
      return RETURN_LONG;
    case 5: 
      return RETURN_FLOAT;
    case 4: 
      return RETURN_DOUBLE;
    case 9: 
      return RETURN_OBJECT;
    }
    return RETURN_VOID;
  }
  
  public static Rop opShl(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, SHL_CONST_INT, SHL_CONST_LONG, null, null, SHL_INT, SHL_LONG, null, null);
  }
  
  public static Rop opShr(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, SHR_CONST_INT, SHR_CONST_LONG, null, null, SHR_INT, SHR_LONG, null, null);
  }
  
  public static Rop opSub(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, SUB_CONST_INT, SUB_CONST_LONG, SUB_CONST_FLOAT, SUB_CONST_DOUBLE, SUB_INT, SUB_LONG, SUB_FLOAT, SUB_DOUBLE);
  }
  
  public static Rop opUshr(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, USHR_CONST_INT, USHR_CONST_LONG, null, null, USHR_INT, USHR_LONG, null, null);
  }
  
  public static Rop opXor(TypeList paramTypeList)
  {
    return pickBinaryOp(paramTypeList, XOR_CONST_INT, XOR_CONST_LONG, null, null, XOR_INT, XOR_LONG, null, null);
  }
  
  private static Rop pickBinaryOp(TypeList paramTypeList, Rop paramRop1, Rop paramRop2, Rop paramRop3, Rop paramRop4, Rop paramRop5, Rop paramRop6, Rop paramRop7, Rop paramRop8)
  {
    int i = paramTypeList.getType(0).getBasicFrameType();
    switch (paramTypeList.size())
    {
    default: 
      paramRop1 = null;
    }
    for (;;)
    {
      paramRop5 = paramRop1;
      if (paramRop1 == null) {
        paramRop5 = throwBadTypes(paramTypeList);
      }
      return paramRop5;
      paramRop5 = paramRop1;
      switch (i)
      {
      }
      for (paramRop3 = null;; paramRop3 = paramRop4)
      {
        paramRop1 = paramRop3;
        break;
        return paramRop2;
      }
      switch (i)
      {
      default: 
        break;
      case 4: 
        paramRop1 = paramRop8;
        break;
      case 6: 
        return paramRop5;
      case 7: 
        return paramRop6;
      case 5: 
        paramRop1 = paramRop7;
      }
    }
  }
  
  private static Rop pickIf(TypeList paramTypeList, Rop paramRop1, Rop paramRop2, Rop paramRop3, Rop paramRop4)
  {
    switch (paramTypeList.size())
    {
    }
    do
    {
      for (;;)
      {
        paramRop1 = throwBadTypes(paramTypeList);
        return paramRop1;
        switch (paramTypeList.getType(0).getBasicFrameType())
        {
        case 6: 
        case 7: 
        case 8: 
        default: 
          break;
        case 9: 
          if (paramRop2 != null)
          {
            return paramRop2;
            int i = paramTypeList.getType(0).getBasicFrameType();
            if (i == paramTypeList.getType(1).getBasicFrameType()) {
              switch (i)
              {
              }
            }
          }
          break;
        }
      }
      return paramRop3;
    } while (paramRop4 == null);
    return paramRop4;
  }
  
  public static Rop ropFor(int paramInt, TypeBearer paramTypeBearer, TypeList paramTypeList, Constant paramConstant)
  {
    switch (paramInt)
    {
    case 42: 
    default: 
      throw new RuntimeException("unknown opcode " + RegOps.opName(paramInt));
    case 1: 
      return NOP;
    case 2: 
      return opMove(paramTypeBearer);
    case 3: 
      return opMoveParam(paramTypeBearer);
    case 4: 
      return opMoveException(paramTypeBearer);
    case 5: 
      return opConst(paramTypeBearer);
    case 6: 
      return GOTO;
    case 7: 
      return opIfEq(paramTypeList);
    case 8: 
      return opIfNe(paramTypeList);
    case 9: 
      return opIfLt(paramTypeList);
    case 10: 
      return opIfGe(paramTypeList);
    case 11: 
      return opIfLe(paramTypeList);
    case 12: 
      return opIfGt(paramTypeList);
    case 13: 
      return SWITCH;
    case 14: 
      return opAdd(paramTypeList);
    case 15: 
      return opSub(paramTypeList);
    case 16: 
      return opMul(paramTypeList);
    case 17: 
      return opDiv(paramTypeList);
    case 18: 
      return opRem(paramTypeList);
    case 19: 
      return opNeg(paramTypeBearer);
    case 20: 
      return opAnd(paramTypeList);
    case 21: 
      return opOr(paramTypeList);
    case 22: 
      return opXor(paramTypeList);
    case 23: 
      return opShl(paramTypeList);
    case 24: 
      return opShr(paramTypeList);
    case 25: 
      return opUshr(paramTypeList);
    case 26: 
      return opNot(paramTypeBearer);
    case 27: 
      return opCmpl(paramTypeList.getType(0));
    case 28: 
      return opCmpg(paramTypeList.getType(0));
    case 29: 
      return opConv(paramTypeBearer, paramTypeList.getType(0));
    case 30: 
      return TO_BYTE;
    case 31: 
      return TO_CHAR;
    case 32: 
      return TO_SHORT;
    case 33: 
      if (paramTypeList.size() == 0) {
        return RETURN_VOID;
      }
      return opReturn(paramTypeList.getType(0));
    case 34: 
      return ARRAY_LENGTH;
    case 35: 
      return THROW;
    case 36: 
      return MONITOR_ENTER;
    case 37: 
      return MONITOR_EXIT;
    case 38: 
      paramTypeList = paramTypeList.getType(0);
      if (paramTypeList == Type.KNOWN_NULL) {}
      for (paramTypeBearer = paramTypeBearer.getType();; paramTypeBearer = paramTypeList.getComponentType()) {
        return opAget(paramTypeBearer);
      }
    case 39: 
      paramTypeBearer = paramTypeList.getType(1);
      if (paramTypeBearer == Type.KNOWN_NULL) {}
      for (paramTypeBearer = paramTypeList.getType(0);; paramTypeBearer = paramTypeBearer.getComponentType()) {
        return opAput(paramTypeBearer);
      }
    case 40: 
      return NEW_INSTANCE;
    case 41: 
      return opNewArray(paramTypeBearer.getType());
    case 43: 
      return CHECK_CAST;
    case 44: 
      return INSTANCE_OF;
    case 45: 
      return opGetField(paramTypeBearer);
    case 46: 
      return opGetStatic(paramTypeBearer);
    case 47: 
      return opPutField(paramTypeList.getType(0));
    case 48: 
      return opPutStatic(paramTypeList.getType(0));
    case 49: 
      return opInvokeStatic(((CstMethodRef)paramConstant).getPrototype());
    case 50: 
      paramTypeBearer = (CstMethodRef)paramConstant;
      return opInvokeVirtual(paramTypeBearer.getPrototype().withFirstParameter(paramTypeBearer.getDefiningClass().getClassType()));
    case 51: 
      paramTypeBearer = (CstMethodRef)paramConstant;
      return opInvokeSuper(paramTypeBearer.getPrototype().withFirstParameter(paramTypeBearer.getDefiningClass().getClassType()));
    case 52: 
      paramTypeBearer = (CstMethodRef)paramConstant;
      return opInvokeDirect(paramTypeBearer.getPrototype().withFirstParameter(paramTypeBearer.getDefiningClass().getClassType()));
    }
    paramTypeBearer = (CstMethodRef)paramConstant;
    return opInvokeInterface(paramTypeBearer.getPrototype().withFirstParameter(paramTypeBearer.getDefiningClass().getClassType()));
  }
  
  private static Rop throwBadType(TypeBearer paramTypeBearer)
  {
    throw new IllegalArgumentException("bad type: " + paramTypeBearer);
  }
  
  private static Rop throwBadTypes(TypeList paramTypeList)
  {
    throw new IllegalArgumentException("bad types: " + paramTypeList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.Rops
 * JD-Core Version:    0.7.0.1
 */